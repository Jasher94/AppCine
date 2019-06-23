package com.softnar.app.service;

import java.util.List;

import com.softnar.app.model.Pelicula;

public interface IPeliculasService {
	
	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	

}
