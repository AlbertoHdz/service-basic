/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.service;

import com.project.api.model.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Draxl
 */
@Service
public class ApiService {
    List lista = new ArrayList(); 
    
    public ApiService(){
       lista.add(new Item(1,"Jose","description").toString());
       lista.add(new Item(2,"Juan","Segundo").toString());
       lista.add(new Item(10,"Ana","juegos").toString());
    }
    
    public List getItems(){
        return lista;
    }
    
    public Item getItem(int idBuscar){
        return (Item) lista.get(idBuscar);
    }
    
    public void agregaItem(Item nv){
        lista.add(nv.toString());
    }
}
