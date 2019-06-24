package com.softnar.app.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.softnar.app.model.Noticia;
import com.softnar.app.model.Pelicula;
import com.softnar.app.service.IBannersService;
import com.softnar.app.service.INoticiasService;
import com.softnar.app.service.IPeliculasService;
import com.softnar.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	@Autowired
	private INoticiasService serviceNoticias;
	@Autowired
	private IBannersService serviceBanners;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha")String fecha, Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		 
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas",peliculas);	
		model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion
		
		System.out.println("Buscando todas las peliculas en cartelera para la fecha:"+fecha);
		return "home";
	}
	
	/////////////////////////////////////////////////
	////////////////////////////////////////////////
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		List<String> listaFechas = Utileria.getNextDays(4);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		/*
		 * peliculas.add("Rapuido y Furioso"); 
		 * peliculas.add("El aro 3");
		 * peliculas.add("Aliens");
		 */
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda",dateFormat.format(new Date()));
		model.addAttribute("peliculas",peliculas);
		model.addAttribute("banners", serviceBanners.buscarTodos()); // Ejercicio : Solucion
		
	return "home";
		
	}
	

	/////////////////////////////////////////////////
	////////////////////////////////////////////////
	
	/* @RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET) */
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	//public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula,@PathVariable("fecha") String fecha) {
	public String mostrarDetalle(Model model,@RequestParam("idMovie") int idPelicula,@RequestParam("fecha") String fecha) {
		System.out.println("Buscando Horarios para la Pelicula : "+idPelicula);
		System.out.println("Para la fecha: "+fecha);
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
		//TOD -  Buscar en la base de datos los horarios
		
		
		return "detalle";
		
	}
	
	@PostMapping(value="/save")
	public String guardar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus,
			@RequestParam("detalle") String detalle){
		
		Noticia noticia = new Noticia();
		noticia.setTitulo(titulo);
		noticia.setEstatus(estatus);
		noticia.setDetalle(detalle);
		
		// Pendiente: Guardar el objeto noticia en la BD		
		
		serviceNoticias.guardar(noticia);
		
		return "noticias/formNoticia";
	}
	
	
	
}

