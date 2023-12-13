package com.roadofdreams.services;



import java.util.List;

import com.roadofdreams.model.Usuario;

public interface UsuarioService {

	List<Usuario> getAllUsuarios ();
	
	Usuario getUsuarioById(Long idUsuario);
	
	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario ( Long idUsuario, Usuario UsuarioAtualizado);
	
	void deleteUsuario(Long idUsuario);
	
	
	
}
