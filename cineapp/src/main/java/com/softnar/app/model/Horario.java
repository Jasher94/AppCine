package com.softnar.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="Horarios")
public class Horario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="fecha",nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String hora;
	private String sala;
	
	@ManyToOne  //muchos horarios a una pelicula
	@JoinColumn(name="idPelicula")
	private Pelicula pelicula;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	@Override
	public String toString() {
		return "Horario [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", sala=" + sala + ", pelicula=" + pelicula
				+ "]";
	}
	
	
	

}
