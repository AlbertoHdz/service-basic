/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.controller;

import org.json.simple.JSONValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alber
 */
@RestController
@RequestMapping("/xml")
public class XmlController {
    
    @GetMapping(value = "/",produces = "application/json; charset=utf-8")
    public String getAllXml(){
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        return xml;
        //return JSONValue.toJSONString(xml);
    }
}
