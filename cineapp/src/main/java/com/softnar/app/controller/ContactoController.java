package com.softnar.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.softnar.app.model.Contacto;
import com.softnar.app.service.IPeliculasService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculasService servicePeliculas;
	
	
	@GetMapping("/contacto")
	public  String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto, Model model) {
		
		model.addAttribute("generos",servicePeliculas.buscarGeneros());
		model.addAttribute("tipos",tipoNotificaciones());
		
		return "formContacto";
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto) {
		
		System.out.println(contacto);
		
		return"redirect:/contacto";
	}
	
	
	private List<String>tipoNotificaciones(){
		List<String> tipos = new LinkedList<>();
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventa");
		return tipos;
		
	}

}
