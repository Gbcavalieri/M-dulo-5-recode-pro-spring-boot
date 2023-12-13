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
import com.roadofdreams.model.Compra;
import com.roadofdreams.services.CompraService;

@Controller
	@RequestMapping("/compras")
	public class CompraController {

		
		@Autowired
		private CompraService compraService;
		@GetMapping
		public String ListCompra (Model model) {
			List<Compra> compras = compraService.getAllCompras();
			model.addAttribute("compras", compras);
			return "listarCompra";
		}
		
		//FORMULÁRIO DE CRIAÇÃO
		@GetMapping ("/novo")
		public String showFormForadd(Model model) {
			Compra compra = new Compra ();
			model.addAttribute ("compra", compra);
			return "compraForm";
			}
		
		//PERSISTENCIA DA CRIAÇÃO
		@PostMapping ("/save")
		public String saveCompra (@ModelAttribute("compra") Compra compra) {
			compraService.saveCompra(compra);
			return "redirect:/compras";
			}
		
		@GetMapping("/editar/{idCompra}") 
		public String exibirFormularioEdicao(@PathVariable("idCompra") Long userIdCompra, Model model) {
		    Compra compra = compraService.getComprasById(userIdCompra);
		    model.addAttribute("compra", compra);
		    return "compraForm"; 
		}
		
		
		@PostMapping("/editar/{id}")
		public String editUser(@PathVariable("idCompra") Long userIdCompra, @ModelAttribute("compra") Compra compra) {
		    Compra compraExistente = compraService.getComprasById(userIdCompra);

		    compraExistente.setFormaPagamento(compra.getFormaPagamento());
		    compraExistente.setData(compra.getData());
		    compraExistente.setValorTotal(compra.getValorTotal());
		     
		   

		    compraService.updateCompra(userIdCompra, compraExistente); 

		    return "redirect:/compras"; 
		}
		
		// EXCLUIR CATEGORIA
		@GetMapping("/deletar/{idCompra}")
		public String deleteCompra(@PathVariable Long idCompra) {
			compraService.deleteCompra(idCompra);
			return "redirect:/compras";
		}
}
