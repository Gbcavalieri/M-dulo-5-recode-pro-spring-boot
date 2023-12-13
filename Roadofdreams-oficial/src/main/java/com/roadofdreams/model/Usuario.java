package com.roadofdreams.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario") 
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	@Column(nullable = false , length = 45 )
	private String nome;
	@Column(nullable = false , length = 45 )
	private String email;
	@Column(nullable = false , length = 45 )
	private String senha;
	@Column(nullable = false , length = 45 )
	private String genero;
	
	
	@OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn( name = "idUsuario")
	private List<Compra> compras;
    
    
	
	public Usuario() {
		
	}

	public Usuario(Long idUsuario, String nome, String email, String senha, String genero, List<Compra> compras) {
		
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.genero = genero;
		this.compras = compras;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	
	
	
	
}
