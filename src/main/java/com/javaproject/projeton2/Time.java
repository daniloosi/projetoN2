package com.javaproject.projeton2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="times")
public class Time {
	@Id @GeneratedValue
	private long id;
	private String nome;
	private int nJogadores;
	private String conferencia;
	private int titulos;
		
	public Time() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNjogadores(){
		return nJogadores;
	}
	public void setNjogadores(int nJogadores) {
		this.nJogadores = nJogadores;
	}
	public String getConferencia(){
		return conferencia;
	}
	public void setConferencia(String conferencia){
		this.conferencia = conferencia;
	}
	public int getTitulos(){
		return titulos;
	}
	public void setTitulos(int titulos){
		this.titulos = titulos;
	}
}