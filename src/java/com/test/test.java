/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author monzo
 */

@Path("test")
public class test {
    
    @GET
    @Path("/getData")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDataInJSON(){
        return "Test";
    }
    
}
