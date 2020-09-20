package com.github.martinpaoloni.ciklumrps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatsController {

    @RequestMapping(value = "/stats")
    public String stats() {
        return "stats";
    }

}
