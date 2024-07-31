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
import org.springframework.web.bind.annotation.PathVariable;
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
        System.out.println("==== datos =====");
        System.out.println(rows);
        return JSONValue.toJSONString(items);
    }
    
    @GetMapping(value = "/item/{idItem}", produces = "application/json; charset=utf-8")
    public String getitem(@PathVariable Integer idItem){
        Map items = new HashMap();
        Item rows = service.getItem(idItem);
        int total = 1;
        items.put("rows", total);
        items.put("data", rows);
        System.out.println("==== datos =====");
        System.out.println(rows);
        return JSONValue.toJSONString(items);
    }
    
    @PostMapping(value = "/item", produces = "application/json; charset=utf-8")
    public String saveItems(@RequestBody Item nv){
        //System.out.println(nv.toString());
        Map item = new HashMap();
        service.agregaItem(nv);
        item.put("status", "ok");
        item.put("nuevo", nv.toString());
        item.put("msg", "agregado con exito");
        System.out.println("Todos los objetos: ");
        Map items = new HashMap();
        items.put("data", service.getItems());
        items.put("inserted", item);
        System.out.println(items);
        
        return JSONValue.toJSONString(items);
    }
}
