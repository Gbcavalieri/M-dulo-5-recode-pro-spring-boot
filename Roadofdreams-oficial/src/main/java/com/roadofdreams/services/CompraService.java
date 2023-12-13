package com.roadofdreams.services;

import java.util.List;

import com.roadofdreams.model.Compra;


public interface CompraService {

	
List<Compra> getAllCompras ();
	
	Compra getComprasById(Long idCompra);
	
	Compra saveCompra(Compra compra);
	
	Compra updateCompra ( Long idCompra, Compra CompraAtualizada);
	
	void deleteCompra(Long idCompra);
	
}
