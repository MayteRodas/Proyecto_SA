/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mayte
 */
public class ConexionF {
    public void conectar(){
    
    System.out.println("Probando conexion FARMACIA");
        try{
                    Class.forName("com.mysql.jdbc.Driver");

	} catch (ClassNotFoundException e) {
            		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();

        }
        
        System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;

	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/farmacia","root", "");

	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
	}
        
        if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
        
    
    }
}
