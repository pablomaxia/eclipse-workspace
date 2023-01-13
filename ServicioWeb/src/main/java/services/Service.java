package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelo.Persona;

@Path("/servicio")
public class Service {
	@POST
	@Path("/calculaIMC")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public float calculaIMC(Persona p) {
		float imc = 0;
		float peso = p.getPeso();
		float altura = p.getAltura();
		
		imc = peso/(altura*altura);
		
		return imc;
	}
}
