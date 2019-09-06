package com.softnar.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.softnar.app.model.Perfil;
import com.softnar.app.model.Usuario;
import com.softnar.app.service.IPerfilesService;
import com.softnar.app.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private IUsuarioService serviceUsuarios;
	
	@Autowired
	private IPerfilesService servicePerfiles;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Usuario usuario) {
		
		return "usuarios/formUsuario";
	}
	
	@GetMapping("/index")
	public String index() {
		
		return "usuarios/listUsuarios";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil) {
		
		System.out.println("Perfil: "+perfil);
		System.out.println("Usuario: "+usuario);
		
		String tmpPass = usuario.getPwd();
		String encriptado =encoder.encode(tmpPass);
		usuario.setPwd(encriptado);
		
		usuario.setActivo(1);
		serviceUsuarios.guardar(usuario);
		
		Perfil perfilTmp = new Perfil();
		perfilTmp.setCuenta(usuario.getCuenta());
		perfilTmp.setPerfil(perfil);	
		servicePerfiles.guardar(perfilTmp);
		
		
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/demo-bcrypt")
	public String pruebaBcrypt() {
		String password = "mari123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado :"+ encriptado);
				
		return "usuarios/demo";
				
	}
	

}
