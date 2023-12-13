package com.roadofdreams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.roadofdreams.model.Usuario;
import com.roadofdreams.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping
	public String ListUsuarios (Model model) {
		List<Usuario> usuarios = usuarioService.getAllUsuarios();
		model.addAttribute("usuario", usuarios);
		return "listarUsuarios";
	}
	
	//FORMULÁRIO DE CRIAÇÃO
	@GetMapping ("/novo")
	public String showFormForadd(Model model) {
		Usuario usuario = new Usuario ();
		model.addAttribute ("usuario", usuario);
		return "usuarioForm";
		}
	
	//PERSISTENCIA DA CRIAÇÃO
	@PostMapping ("/save")
	public String saveUsuario (@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "listarUsuarios";
		}
	
	@GetMapping("/editar/{idUsuario}") 
	public String exibirFormularioEdicao(@PathVariable("idUsuario") Long userIdUsuario, Model model) {
	    Usuario usuario = usuarioService.getUsuarioById(userIdUsuario);
	    model.addAttribute("usuario", usuario);
	    return "editarUsuario"; 
	}
	
	
	@PostMapping("/editarUsuario/{idUsuario}")
	public String editUser(@PathVariable("idUsuario") Long userIdUsuario, @ModelAttribute("usuario") Usuario usuario) { 
	    usuarioService.updateUsuario(userIdUsuario, usuario); 
	    return "redirect:/usuarios"; 
	}
	
	// EXCLUIR CATEGORIA
	@GetMapping("/deletarUsuario/{idUsuario}")
	public String deleteUsuario(@PathVariable Long idUsuario) {
		usuarioService.deleteUsuario(idUsuario);
		return "redirect:/usuarios";
	}
}
