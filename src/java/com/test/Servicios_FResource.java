/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.farma.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Mayte
 */
@Path("Servicios_F")
public class Servicios_FResource {

    /**
    *
    * @SERVICIO 2
    */
    @GET
    @Path("/obtiene_existencias")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<sp_obtiene_existencias> getDataInJSON(@QueryParam("id_medicamento") int id_medicamento){
        
        ArrayList<sp_obtiene_existencias> tm = new ArrayList<>();
        
        Connection conn = connect();
        
        if (conn != null){
            
            String proc = "{ call sp_obtiene_existencias(?) }";
            CallableStatement cs; 
            try {
                    cs = conn.prepareCall(proc);
                    cs.setInt(1, id_medicamento);
                    
                    cs.executeQuery();
                    
                    sp_obtiene_existencias oex = new sp_obtiene_existencias();
                    oex.setId_medicamento(id_medicamento);

                    tm.add(oex);
                    
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Servicios_CSResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return tm;
    }
    
    
    /**
    *
    * @SERVICIO 6
    */
    @GET
    @Path("/trasladoMedicamento")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<sp_agrega_traslado> getDataInJSON(@QueryParam("fecha") String fecha, @QueryParam("id_origen") int id_origen, @QueryParam("id_destino") int id_destino){
        
        ArrayList<sp_agrega_traslado> tm = new ArrayList<>();
        
        Connection conn = connect();
        
        if (conn != null){
            
            String proc = "{ call sp_obtiene_existencias(?,?,?) }";
            CallableStatement cs; 
            try {
                    cs = conn.prepareCall(proc);
                    cs.setString(1, fecha);
                    cs.setInt(2, id_origen);
                    cs.setInt(3, id_destino);
                    
                    cs.executeQuery();
                    
                    sp_agrega_traslado atr = new sp_agrega_traslado();
                    atr.setFecha(fecha);
                    atr.setId_origen(id_origen);
                    atr.setId_destino(id_destino);
                    
                    //AQUI ESTA LA OTRA CLASE
                    sp_agrega_detalle_traslado dt = new sp_agrega_detalle_traslado();
                    dt.setCantidad(id_origen);
                    dt.setCantidad(id_origen);
                    dt.setId_traslado(id_destino);
                    
                    atr.dtraslado.add(dt);

                    tm.add(atr);
                    
                    conn.close();
                    
            } catch (SQLException ex) {
                Logger.getLogger(Servicios_CSResource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tm;
    }
    
    
    
    
    
    
    
    
    
    
    public Connection connect(){
	try {	
            Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return null;
	}

	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;

	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/farmacia","root", "");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return null;
	}

	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
        
        return connection;
    }
}
