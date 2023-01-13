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
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario validaUsuario(Usuario u) {
		u.setUserValido(false);
		if (u.getUsuario().equals("pepito")&& u.getPassword().equals("González")) {
			u.setUserValido(true);
		}
		return u;
	}
}
