package com.github.martinpaoloni.ciklumrps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayGameController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
