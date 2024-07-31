/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.controller;

import com.project.api.service.MapService;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alber
 */
@RestController
@RequestMapping("/map")
public class MapController {
    
    @Autowired
    MapService mapService;
    
    @GetMapping(produces = "application/json; charset=utf-8")
    public String getMapas(){
        return JSONValue.toJSONString(mapService.getMapa());
    }
    
    @GetMapping(value = "/{idBuscar}", produces = "application/json; charset=utf-8")
    public String getValor(@PathVariable int idBuscar){
        return mapService.getValor(idBuscar).toString();
    }
}
