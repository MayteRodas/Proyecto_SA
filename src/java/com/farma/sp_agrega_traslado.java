/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farma;

/**
 *
 * @author Mayte
 */
public class sp_agrega_traslado {
    private String fecha;
    private int id_origen;
    private int id_destino;

    public sp_agrega_traslado(String fecha, int id_origen, int id_destino) {
        this.fecha = fecha;
        this.id_origen = id_origen;
        this.id_destino = id_destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_origen() {
        return id_origen;
    }

    public void setId_origen(int id_origen) {
        this.id_origen = id_origen;
    }

    public int getId_destino() {
        return id_destino;
    }

    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }
    
}
