package com.roadofdreams.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "tb_compra")
public class Compra {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCompra;

@Column(nullable = false , length = 45 )
private String data;

@Column(nullable = false , length = 45 )
private String formaPagamento;

@Column(nullable = false , length = 45 )
private String valorTotal;

@ManyToOne
@JoinColumn(name = "idPassagem")
private Passagem passagens;


@ManyToOne
private Compra compra;

public Compra() {
	
	
}
	
public Compra(Long idCompra, String data, String formaPagamento, String valorTotal, Passagem passagens, Compra compra) {
	
	this.idCompra = idCompra;
	this.data = data;
	this.formaPagamento = formaPagamento;
	this.valorTotal = valorTotal;
	this.passagens = passagens;
	this.compra = compra;
}

public Long getIdCompra() {
	return idCompra;
}

public void setIdCompra(Long idCompra) {
	this.idCompra = idCompra;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public String getFormaPagamento() {
	return formaPagamento;
}

public void setFormaPagamento(String formaPagamento) {
	this.formaPagamento = formaPagamento;
}

public String getValorTotal() {
	return valorTotal;
}

public void setValorTotal(String valorTotal) {
	this.valorTotal = valorTotal;
}

public Passagem getPassagens() {
	return passagens;
}

public void setPassagens(Passagem passagens) {
	this.passagens = passagens;
}

public Compra getCompra() {
	return compra;
}

public void setCompra(Compra compra) {
	this.compra = compra;
}
	



}

