/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;



/**
 *
 * @author monzo
 */
public class CS_Connection {

    public static void main (String [ ] args) {
    
        ConexionCS ccs = new ConexionCS();
        ConexionF cf = new ConexionF();
        
        ccs.conectar();
        cf.conectar();
        
    }
    
}
