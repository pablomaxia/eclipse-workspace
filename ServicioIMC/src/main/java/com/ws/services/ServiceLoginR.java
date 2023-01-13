package com.ws.services;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.ws.modelo.Persona;

@Path ("/MiServicio")
public class ServiceLoginR {
	
	@POST
	@Path("/calculaIMC")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public float calculaIMC(Persona p) {
		float calculaIMC = 0;
		float peso = p.getPeso();
		float altura = p.getAltura();
		
		calculaIMC = peso/(altura*altura);
		return calculaIMC;
	}
	
	@POST
	@Path("/mensajeIMC")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public String calculaIMCIdeal(Persona p) {
		String cad="";
		if(calculaIMC(p)<16.00){
		  cad="Infrapeso: Delgadez Severa";
		}else if(calculaIMC(p)<=16.00 || calculaIMC(p)<=16.99){
		  cad="Infrapeso: Delgadez moderada";
		}else if(calculaIMC(p)<=17.00 ||calculaIMC(p)<=18.49){
		  cad="Infrapeso: Delgadez aceptable";
		}else if(calculaIMC(p)<=18.50 || calculaIMC(p)<=24.99){
		  cad="Peso Normal";
		}else if(calculaIMC(p)<=25.00 || calculaIMC(p)<=29.99){
		  cad="Sobrepeso";
		}else if(calculaIMC(p)<=30.00 || calculaIMC(p)<=34.99){
		  cad="Obeso: Tipo I";
		}else if(calculaIMC(p)<=35.00 || calculaIMC(p)==40.00){
		  cad="Obeso: Tipo III";
		}else{
		  cad="no existe clasificacion";
		}
		  return cad + " Peso: " + calculaIMC(p);
	}
}