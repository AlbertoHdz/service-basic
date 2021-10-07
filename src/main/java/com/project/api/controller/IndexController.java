/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.controller;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Draxl
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("tstamp", LocalDateTime.now());
        
        return "index";
    }
}
