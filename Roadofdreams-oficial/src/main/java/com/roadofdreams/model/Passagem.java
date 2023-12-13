package com.roadofdreams.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_passagem")
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPassagem;

    @Column(nullable = false , length = 45 )
    private String origem;

    @Column(nullable = false , length = 45 )
    private String destino;

    @Column
    private LocalDate dataIda;

    @Column
    private LocalDate dataVolta;

    @Column(nullable = false , length = 45 )
    private String agencia;

    @Column(nullable = false  )
    private int quantidadeLugares;

    @OneToMany
    private List<Compra> compras;

    public Passagem() {
		}
    
    public Passagem(Long idPassagem, String origem, String destino, LocalDate dataIda, LocalDate dataVolta,
			String agencia, int quantidadeLugares, List<Compra> compras) {
		
		this.idPassagem = idPassagem;
		this.origem = origem;
		this.destino = destino;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.agencia = agencia;
		this.quantidadeLugares = quantidadeLugares;
		this.compras = compras;
	}

	public Long getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(Long idPassagem) {
		this.idPassagem = idPassagem;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getDataIda() {
		return dataIda;
	}

	public void setDataIda(LocalDate dataIda) {
		this.dataIda = dataIda;
	}

	public LocalDate getDataVolta() {
		return dataVolta;
	}

	public void setDataVolta(LocalDate dataVolta) {
		this.dataVolta = dataVolta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public int getQuantidadeLugares() {
		return quantidadeLugares;
	}

	public void setQuantidadeLugares(int quantidadeLugares) {
		this.quantidadeLugares = quantidadeLugares;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}


}
