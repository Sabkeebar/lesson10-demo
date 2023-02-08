package edu.miu.cs.cs425.fairfieldlibrarywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/fairfieldlibrary"})
public class HomepageController {

    @GetMapping(value = {"/", "/home"})
    public String displayHomepage() {
        return "public/home/index";
    }

    @GetMapping(value = {"/about"})
    public String displayAboutpage() {
        return "public/home/about";
    }

}
