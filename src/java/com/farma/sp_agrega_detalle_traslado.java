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
public class sp_agrega_detalle_traslado {
    
    private int id_traslado;
    private int id_medicamento;
    private int cantidad;

    public sp_agrega_detalle_traslado(int id_traslado, int id_medicamento, int cantidad) {
        this.id_traslado = id_traslado;
        this.id_medicamento = id_medicamento;
        this.cantidad = cantidad;
    }

    public int getId_traslado() {
        return id_traslado;
    }

    public void setId_traslado(int id_traslado) {
        this.id_traslado = id_traslado;
    }

    public int getId_medicamento() {
        return id_medicamento;
    }

    public void setId_medicamento(int id_medicamento) {
        this.id_medicamento = id_medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    
}
