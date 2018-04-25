/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import java.sql.CallableStatement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.ws.rs.QueryParam;

/**
 *
 * @author monzo
 */
@Path("testController")
public class testController {
    
    @GET
    @Path("/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<centroSalud> getDataInJSON(@QueryParam("nombre") String nombre, @QueryParam("direccion") String direccion) throws SQLException{
        ArrayList<centroSalud> tm = new ArrayList<>();
        Connection conn = connect();
        if (conn != null){
            
            String proc = "{ call sp_agrega_centro(?,?) }";
            CallableStatement cs = conn.prepareCall(proc); 
            cs.setString(1, nombre);
            cs.setString(2, direccion);
            cs.executeQuery();
            
            centroSalud cS = new centroSalud();
            cS.setDireccion(direccion);
            cS.setNombre(nombre);
            
            tm.add(cS);
            
            //String query = "SELECT * FROM paciente";
            //Statement st = conn.createStatement();
            //ResultSet rs = st.executeQuery(query);
            
            /*while(rs.next()){
                testModel tmm = new testModel();
                /*tmm.setIdPaciente(rs.getString("idPaciente"));
                tmm.setDpi(rs.getString("dpi"));
                tmm.setNombre(rs.getString("nombre"));
                tmm.setApellido(rs.getString("apellido"));
                tmm.setTelefono(rs.getString("telefono"));
                tmm.setCelular(rs.getString("celular"));
                tmm.setDireccion(rs.getString("direccion"));
                tmm.setEstado(rs.getString("estado"));
                tmm.setFechaNacimiento(rs.getString("fechaNacimiento"));
                tmm.setIdPaciente("1");
                tmm.setDpi("1659796310101");
                tmm.setNombre("Carlos");
                tmm.setApellido("Monzon");
                tmm.setTelefono("24326895");
                tmm.setCelular("43355449");
                tmm.setDireccion("Guatemala");
                tmm.setEstado("1");
                tmm.setFechaNacimiento("19-05-1990");
                tm.add(tmm);
            }*/
        }
        
        conn.close();
        
        
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
