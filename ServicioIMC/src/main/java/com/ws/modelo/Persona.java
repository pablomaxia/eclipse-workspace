package com.ws.modelo;

public class Persona {
	private int edad;
	private float altura;
	private float peso;
	
	public Persona() {
		
	}
	
	public Persona(int edad, float altura, float peso) {
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
}