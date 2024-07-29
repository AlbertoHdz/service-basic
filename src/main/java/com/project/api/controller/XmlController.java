/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.controller;

import com.project.api.service.XmlService;
import java.util.List;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    XmlService xmlService;
    
    @GetMapping(value = "/",produces = "application/json; charset=utf-8")
    public String getAllXml(){
        //String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        List xml = xmlService.getLista();
        System.out.println("**** LISTA DE XML******");
        System.out.println(xml.toString());
        return xml.toString();
        //return JSONValue.toJSONString(xml);
    }
}
