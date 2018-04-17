/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sa_test;

import java.util.ArrayList;

/**
 *
 * @author mayte
 */
public class Nodo {
    public String name="";
    public ArrayList<Nodo> hijos;
    public int id, linea, columna;
    
    public Nodo(){
        this.hijos = new ArrayList<Nodo>();
    }
    
    public Nodo(String pvalor){
        this.name = pvalor;//.replace("\"", "");
        this.hijos = new ArrayList<Nodo>();
    }
    
    public Nodo(String pvalor, int plin, int pcol){
        this.name = pvalor;//.replace("\"", "").replace("'","");
        this.hijos = new ArrayList<Nodo>();
        this.linea = plin;
        this.columna = pcol;
    }
   
    public void guardarNom(String nombre){
        System.out.println("Este es el nombre: " + nombre);
    }
}

