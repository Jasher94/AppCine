package com.softnar.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.softnar.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService{
	
	private 	List<Pelicula> lista = null;
	
	

	public   PeliculasServiceImpl() {
		System.out.println("Creando una instancia de la clase PeliculasServiceImpl");
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
	
		try {
			lista = new LinkedList<>();
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Ranger");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
			/*
			 * pelicula1.setImagen("kong.png"); pelicula1.setEstatus("Inactiva");
			 */
			

			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(120);
			pelicula2.setClasificacion("B");
			pelicula2.setGenero("Aventura");
			pelicula2.setFechaEstreno(formatter.parse("10-05-2017"));
			pelicula2.setImagen("bella.png");
			/* pelicula2.setEstatus("Inactiva"); */
			

			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(120);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Aventura");
			pelicula3.setFechaEstreno(formatter.parse("20-05-2017"));
			pelicula3.setImagen("contratiempo.png");
			
			


			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("kong la Isla Calavera ");
			pelicula4.setDuracion(118);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion y Aventure");
			pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
			pelicula4.setImagen("kong.png");
			pelicula4.setEstatus("Inactiva");
			

			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(4);
			pelicula5.setTitulo("kong la Isla Calavera ");
			pelicula5.setDuracion(118);
			pelicula5.setClasificacion("A");
			pelicula5.setGenero("Accion y Aventure");
			pelicula5.setFechaEstreno(formatter.parse("06-06-2017"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Inactiva");
			
			//agregamos los objetos pelicula a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
			
			 
			
			
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			 
			// TODO: handle exception
		}
	}
	
	
	
	@Override
	public List<Pelicula> buscarTodas() {
	
		return lista;
	}



	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for(Pelicula p:lista) {
			if(p.getId()==idPelicula) {
				return p;
				
			}
		}		
		return null;
	}



	@Override
	public void insertar(Pelicula pelicula) {
		
		lista.add(pelicula);
		System.out.println("insertando Pelicula: "+pelicula);
		
	}



	@Override
	public List<String> buscarGeneros() {
		
		//Nota:   Esta lista podria ser obtenida de una BD
		List<String> generos = new LinkedList();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Ciencia Ficcion");
		
		
		return generos;
	}

}
