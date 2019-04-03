package com.ibm.mdm.sample.rest;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeoutException;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sample")
public class RestServer {

	@GET
	@Path("/available")
	@Produces(MediaType.TEXT_PLAIN)
	public String available() {
		return "yes";
	}
	
	@PUT
    @Path("/publishMessage")
    @Produces(MediaType.APPLICATION_JSON)
    public String publishMessage(String message) {
		
		Publisher pub = new Publisher();
		
		if (message == null || message.equals("") ) {
			message = "I haven't recieved the Message";
		}
		try {
			pub.publishMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Message Published";
	}
   
}
