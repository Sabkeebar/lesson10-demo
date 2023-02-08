package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"", "/", "/fairfieldlibrary"})
public class HomepageController {

    @GetMapping(value = {"", "/home"})
//    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayHomepage() {
        return "index";
    }

    @GetMapping(value = {"/about"})
    public String displayAboutUsPage() {
        return "about";
    }

}
