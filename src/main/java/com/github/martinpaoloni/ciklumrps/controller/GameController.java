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

/**
 * Controller exposes the Game REST API
 */
@RestController
@RequestMapping("/api/game")
public class GameController {

    /**
     * Stores all games in memory.
     */
    private Map<Integer, Game> games = new ConcurrentHashMap<>();
    /**
     * Used to generate unique IDs for games.
     */
    private AtomicInteger lastIdUsed = new AtomicInteger();
    /**
     * Holds the global stats for all rounds played.
     */
    private Stats globalStats = new Stats();

    /**
     * Lists all the games.
     *
     * @return A {@link Collection} of {@link Game}s.
     */
    @GetMapping(produces = "application/json")
    public Collection<Game> listGames() {
        return games.values();
    }

    /**
     * Gets the global stats for all rounds played.
     *
     * @return A {@link Stats} object with all the required information.
     */
    @GetMapping(value = "/stats", produces = APPLICATION_JSON_VALUE)
    public Stats stats() {
        return globalStats;
    }

    /**
     * Gets a {@link Game} by ID.
     *
     * @param id The ID of the {@link Game} to fetch.
     * @return The requested {@link Game}.
     */
    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public Game game(@PathVariable(value = "id") int id) {
        return Optional.ofNullable(games.get(id)).orElseThrow(() -> new GameNotFoundException(id));
    }

    /**
     * Creates a new {@link Game} and assigns an ID to it.
     *
     * @return The new {@link Game}.
     */
    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Game startGame() {
        Game game = new Game(generateId(), new RandomPlayer(), new RockPlayer());
        games.put(game.getId(), game);
        return game;
    }

    /**
     * Plays a new {@link Round} in a {@link Game}.
     *
     * @param id The ID of the {@link Game} to add a round to.
     * @return The {@link Round} played.
     */
    @PostMapping(value = "/{id}/round", produces = APPLICATION_JSON_VALUE)
    public Round playRound(@PathVariable(value = "id") int id) {
        Round round = game(id).playRound();
        globalStats.countRound(round);
        return round;
    }

    /**
     * Deletes all the {@link Round}s of a {@link Game}.
     *
     * @param id The ID of the {@link Game} to delete all the rounds from.
     * @return The now round-less {@link Game}.
     */
    @DeleteMapping(value = "/{id}/rounds", produces = APPLICATION_JSON_VALUE)
    public Game deleteRounds(@PathVariable(value = "id") int id) {
        return game(id).restartGame();
    }

    private int generateId() {
        return lastIdUsed.incrementAndGet();
    }

}
