/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.controller;

import com.project.api.model.Item;
import com.project.api.service.ApiService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Draxl
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    ApiService service;
    
    @GetMapping(produces = "application/json; charset=utf-8")
    public String demo(){
        Map items = new HashMap();
        items.put("rows", "total");
        return JSONValue.toJSONString(items);
    }
    
    @GetMapping(value = "/item", produces = "application/json; charset=utf-8")
    public String getitems(){
        Map items = new HashMap();
        List rows = service.getItems();
        int total = rows.size();
        items.put("rows", total);
        items.put("data", rows);
        return JSONValue.toJSONString(items);
    }
    
    @PostMapping(value = "/item", produces = "application/json; charset=utf-8")
    public String saveItems(@RequestBody Item nv){
        //System.out.println(nv.toString());
        Map items = new HashMap();
        service.agregaItem(nv);
        items.put("status", "ok");
        items.put("nuevo", nv.toString());
        items.put("msg", "agregado con exito");
        System.out.println("Todos los objetos: ");
        System.out.println(service.getItems());
        return JSONValue.toJSONString(items);
    }
}
