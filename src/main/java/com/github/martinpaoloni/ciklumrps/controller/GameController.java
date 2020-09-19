package com.github.martinpaoloni.ciklumrps.controller;

import com.github.martinpaoloni.ciklumrps.exception.GameNotFoundException;
import com.github.martinpaoloni.ciklumrps.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class GameController {

    private Map<String, Game> games = new HashMap<>();
    private Stats globalStats = new Stats();

    @GetMapping(value = "/api/game", produces = "application/json")
    public Map<String, Game> listGames() {
        return games;
    }

    @GetMapping(value = "/api/game/stats", produces = APPLICATION_JSON_VALUE)
    public Stats stats() {
        return globalStats;
    }

    @GetMapping(value = "/api/game/{id}", produces = APPLICATION_JSON_VALUE)
    public Game game(@PathVariable(value = "id") String id) {
        return Optional.ofNullable(games.get(id)).orElseThrow(() -> new GameNotFoundException(id));
    }

    @PostMapping(value = "/api/game", produces = APPLICATION_JSON_VALUE)
    public Game startGame(@RequestBody(required = true) IdEntity id) {
        Game game = new Game(new RandomPlayer(), new RockPlayer());
        games.put(id.getId(), game);
        return game;
    }

    @PostMapping(value = "/api/game/{id}/round", produces = APPLICATION_JSON_VALUE)
    public Round playRound(@PathVariable(value = "id") String id) {
        Round round = game(id).playRound();
        globalStats.countRound(round);
        return round;
    }

    @DeleteMapping(value = "/api/game/{id}/rounds", produces = APPLICATION_JSON_VALUE)
    public Game deleteRounds(@PathVariable(value = "id") String id) {
        return game(id).restartGame();
    }

}
