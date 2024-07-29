/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alber
 */
@Service
public class XmlService {
    ArrayList lista = new ArrayList();
    
    {
        lista.add(new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
        lista.add(new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
        lista.add(new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
        lista.add(new String("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
    }
    
    public List getLista(){
        return lista;
    }
    
    @Override
    public String toString(){
        StringBuilder salida = new StringBuilder();
        for(Object item : lista){
            salida.append(item.toString());
        }
        return salida.toString();
    }
}
