package com.roadofdreams.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadofdreams.model.Compra;
import com.roadofdreams.repositories.CompraRepository;
import com.roadofdreams.services.CompraService;



	
	@Service
	public class CompraServiceImpl implements CompraService {

		@Autowired
		private CompraRepository compraRepository;
		
		@Override
		public List<Compra> getAllCompras() {
			return compraRepository.findAll();
		}

		@Override
		public Compra getComprasById(Long idCompra) {
			return compraRepository.findById(idCompra).orElse(null);
		}

		@Override
		public Compra saveCompra(Compra compra) {
		return compraRepository.save(compra);
		}

		@Override
		public Compra updateCompra(Long idCompra, Compra CompraAtualizada) {
	    Compra compraExistente = compraRepository.findById(idCompra).orElse(null);
	    if (compraExistente != null);
	    compraExistente.setFormaPagamento(CompraAtualizada.getFormaPagamento());
	    compraExistente.setData(CompraAtualizada.getData());
	    compraExistente.setValorTotal(CompraAtualizada.getValorTotal());
	   
	    return compraRepository.save(compraExistente);
		}

		@Override
		public void deleteCompra(Long idCompra) {
			compraRepository.deleteById(idCompra);
			
		}
}
