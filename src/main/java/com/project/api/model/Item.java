/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.api.model;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONValue;

/**
 *
 * @author Draxl
 */
public class Item {
    int uid;
    String nombre;
    String descripcion;
    
    public Item(int id,String nm, String desc){
        uid = id;
        nombre = nm;
        descripcion = desc;
    }
    
    public String toString(){
        Map sal =  new HashMap();
        sal.put("uid", uid);
        sal.put("nombre", nombre);
        sal.put("descripcion", descripcion);
        
        return JSONValue.toJSONString(sal);
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
