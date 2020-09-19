package com.github.martinpaoloni.ciklumrps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Martin Paoloni's attempt at Ciklum/Lottoland's Rock-Paper-Scissors exercise.
 */
@SpringBootApplication
public class CiklumRpsApplication {

    /**
     * Entry point of the app.
     *
     * @param args The command-line arguments. You can leave this blank.
     */
    public static void main(String[] args) {
        SpringApplication.run(CiklumRpsApplication.class, args);
    }

}
