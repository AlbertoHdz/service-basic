/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alber
 */
@Service
public class MapService {
    Map mapa = new HashMap<Object, Object>();

    public MapService() {
        mapa.put(1, "valor1");
        mapa.put(2, "valor2");
        mapa.put(3, "valor3");
        mapa.put(4, "valor4");
        mapa.put(5, "valor5");
        
    }
    
    public Map getMapa(){
        return mapa;
    }
    
    public Object getValor(Object idBuscar){
        return mapa.get(idBuscar);
    }
}
