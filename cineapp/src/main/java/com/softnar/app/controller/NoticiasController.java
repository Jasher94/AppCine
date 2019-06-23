package com.softnar.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softnar.app.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	
	@GetMapping(value="/create")
	public String crear() {
		
		return "noticias/formNoticia";
	}
	
	@PostMapping(value="/save")
	public String guardar(Noticia noticia) {
		
		
		//Pendiente Guardar el objeto noticia en la base de datos
		
		
		
		System.out.println(noticia ); 
		
		return "noticias/formNoticia";
	}
}
