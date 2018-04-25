/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import com.centroS.*;
import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author Mayte
 */
@Path("Servicios_CS")
public class Servicios_CSResource {

    @GET
    @Path("/traslado_paciente")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<sp_traslado_paciente> getDataInJSON(@QueryParam("dpi") String dpi, @QueryParam("idorigen") int idorigen, @QueryParam("iddestino") int iddestino){
        
        ArrayList<sp_traslado_paciente> tm = new ArrayList<>();
        
        Connection conn = connect();
        
        if (conn != null){
            
            String proc = "{ call sp_traslado_paciente(?,?,?) }";
            CallableStatement cs; 
            try {
                    cs = conn.prepareCall(proc);
                    cs.setString(1, dpi);
                    cs.setInt(2, idorigen);
                    cs.setInt(3, iddestino);
                    
                    cs.executeQuery();
                    
                    sp_traslado_paciente sp = new sp_traslado_paciente();
                    sp.setDpi(dpi);
                    sp.setId_origen(idorigen);
                    sp.setId_destino(iddestino);

                    tm.add(sp);
                    
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
		.getConnection("jdbc:mysql://localhost:3306/centro_salud","root", "");

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
