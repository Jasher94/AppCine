package com.softnar.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softnar.app.model.Pelicula;
import com.softnar.app.service.IPeliculasService;
import com.softnar.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired //inyectando dependencia de IPeliculasService
	private IPeliculasService servicePeliculas;
	
	@GetMapping("/index")// mapeando la url /index a la vista peliculas/listaPeliculas
	public String mostrarIndex(Model model) {
		List<Pelicula> lista = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas",lista);
		
		return "peliculas/listPeliculas";
		
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		model.addAttribute("generos",servicePeliculas.buscarGeneros());
		return "peliculas/formPelicula";
	}
	
	/////////////////////////////////////////////////////
	///////Method to save  Pelicula Details///////////
	/////////////////////////////////////////////////////

	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart,HttpServletRequest request	) {

		
		  if(result.hasErrors()) { 
			  System.out.println("Existieron errores"); 
			  
			 return "peliculas/formPelicula";
			 }
		  if(!multiPart.isEmpty()) {
			  String nombreImagen = Utileria.guardarImagen(multiPart,request);
			  pelicula.setImagen(nombreImagen);
		  }
		 
		/*for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}*/

		System.out.println("guardando: " + pelicula);
		System.out.println("Elementos en la lista antes de la insersion:"+servicePeliculas.buscarTodas().size());
		servicePeliculas.insertar(pelicula);
		System.out.println("Elementos en la lista despues de la insersion:"+servicePeliculas.buscarTodas().size());
		/* return "peliculas/formPelicula"; */
		attributes.addFlashAttribute("mensaje", "Registro Guardado");
		return "redirect:/peliculas/index";
	}
	
	

	/////////////////////////////////////////////////////
	///////////Method to format the Date Format/////////// 
	/////////////////////////////////////////////////////
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
