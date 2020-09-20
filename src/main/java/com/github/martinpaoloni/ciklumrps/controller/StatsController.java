package com.github.martinpaoloni.ciklumrps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller that provides the stats view.
 */
@Controller
public class StatsController {

    /**
     * Serves the stats view.
     *
     * @return A reference to the stats page.
     */
    @RequestMapping(value = "/stats")
    public String stats() {
        return "stats";
    }

}
