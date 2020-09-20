package com.github.martinpaoloni.ciklumrps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller that provides the main view of the application.
 */
@Controller
public class IndexController {

    /**
     * Serves the main view of the application.
     *
     * @return A reference to the index page.
     */
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}
