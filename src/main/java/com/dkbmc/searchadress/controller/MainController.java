package com.dkbmc.searchadress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", ""})
    public String indexPage() {
        return "page/index";
    }

}
