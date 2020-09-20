package com.github.martinpaoloni.ciklumrps.controller;

import com.github.martinpaoloni.ciklumrps.exception.GameNotFoundException;
import com.github.martinpaoloni.ciklumrps.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GameController {

    private Map<Integer, Game> games = new ConcurrentHashMap<>();
    private AtomicInteger lastIdUsed = new AtomicInteger();
    private Stats globalStats = new Stats();

    @GetMapping(value = "/api/game", produces = "application/json")
    public Collection<Game> listGames() {
        return games.values();
    }

    @GetMapping(value = "/api/game/stats", produces = APPLICATION_JSON_VALUE)
    public Stats stats() {
        return globalStats;
    }

    @GetMapping(value = "/api/game/{id}", produces = APPLICATION_JSON_VALUE)
    public Game game(@PathVariable(value = "id") int id) {
        return Optional.ofNullable(games.get(id)).orElseThrow(() -> new GameNotFoundException(id));
    }

    @PostMapping(value = "/api/game", produces = APPLICATION_JSON_VALUE)
    public Game startGame() {
        Game game = new Game(generateId(), new RandomPlayer(), new RockPlayer());
        games.put(game.getId(), game);
        return game;
    }

    @PostMapping(value = "/api/game/{id}/round", produces = APPLICATION_JSON_VALUE)
    public Round playRound(@PathVariable(value = "id") int id) {
        Round round = game(id).playRound();
        globalStats.countRound(round);
        return round;
    }

    @DeleteMapping(value = "/api/game/{id}/rounds", produces = APPLICATION_JSON_VALUE)
    public Game deleteRounds(@PathVariable(value = "id") int id) {
        return game(id).restartGame();
    }

    private int generateId() {
        return lastIdUsed.incrementAndGet();
    }

}
