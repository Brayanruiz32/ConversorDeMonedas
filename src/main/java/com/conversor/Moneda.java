package com.conversor;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.gson.annotations.SerializedName;

public class Moneda {
    
    
    private String monedaBase;
    
    private Map<String, Double> conversiones = new HashMap<String, Double>();


    public Moneda(MonedaRecord miMoneda) {
        this.monedaBase = miMoneda.base_code();
         this.conversiones = miMoneda.conversion_rates();
    } 
    public double getConversiones(String moneda) {
        //Set<String> miKey = conversiones.keySet();
        return  conversiones.get(moneda);
    }
    public void setConversiones(Map<String, Double> conversiones) {
        this.conversiones = conversiones;
    }
    public String getMonedaBase() {
        return monedaBase;
    }
    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }
    @Override
    public String toString() {
        return "Moneda [monedaBase=" + monedaBase + ", conversiones=" + conversiones + "]";
    }

    


    

}
