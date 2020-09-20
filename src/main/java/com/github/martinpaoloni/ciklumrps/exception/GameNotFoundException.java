package com.github.martinpaoloni.ciklumrps.exception;

import com.github.martinpaoloni.ciklumrps.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be thrown when a requested {@link Game} is not found.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Game not found")
public class GameNotFoundException extends RuntimeException {

    /**
     * Creates a {@link GameNotFoundException} instance.
     *
     * @param id the ID of the {@link Game} that was not found.
     */
    public GameNotFoundException(int id) {
        super(String.format("Could not found Game with id = %d", id));
    }
}
