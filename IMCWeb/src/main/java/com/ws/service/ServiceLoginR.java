package com.ws.service;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.ws.modelo.Usuario;

@Path ("/MiServicio")
public class ServiceLoginR {
	
	@POST
	@Path("/calculaIMC")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public float calculaIMC(Usuario u) {
		float imc = 0;
		float peso = u.getPeso();
		float altura = u.getAltura();
		
		imc = peso/(altura*altura);
		
		return imc;
	}
}
