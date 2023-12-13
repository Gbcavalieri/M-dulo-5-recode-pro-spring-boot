package com.roadofdreams.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadofdreams.model.Usuario;
import com.roadofdreams.repositories.UsuarioRepository;
import com.roadofdreams.services.UsuarioService;



@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuarioById(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
	return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Long idUsuario, Usuario UsuarioAtualizado) {
    Usuario usuarioExistente = usuarioRepository.findById(idUsuario).orElse(null);
    if (usuarioExistente != null);
    usuarioExistente.setNome(UsuarioAtualizado.getNome());
    usuarioExistente.setEmail(UsuarioAtualizado.getEmail());
    usuarioExistente.setSenha(UsuarioAtualizado.getSenha());
    usuarioExistente.setGenero(UsuarioAtualizado.getGenero());
    return usuarioRepository.save(usuarioExistente);
	}

	@Override
	public void deleteUsuario(Long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
		
	}

}
