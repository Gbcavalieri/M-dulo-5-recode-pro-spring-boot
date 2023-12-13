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

import com.roadofdreams.model.Passagem;
import com.roadofdreams.services.PassagemService;


	@Controller
	@RequestMapping("/passagens")
	public class PassagemController {

		
		@Autowired
		private PassagemService passagemService;
		@GetMapping
		public String ListPassagem (Model model) {
			List<Passagem> passagens = passagemService.getAllPassagens();
			model.addAttribute("passagens", passagens);
			return "listarPassagem";
		}
		
		//FORMULÁRIO DE CRIAÇÃO
		@GetMapping ("/novo")
		public String showFormForadd(Model model) {
			Passagem passagem = new Passagem ();
			model.addAttribute ("passagem", passagem);
			return "passagemForm";
			}
		
		//PERSISTENCIA DA CRIAÇÃO
		@PostMapping ("/save")
		public String savePassagem (@ModelAttribute("passagem") Passagem passagem) {
			passagemService.savePassagem(passagem);
			return "redirect:/passagens";
			}
		
		@GetMapping("/editar/{idPassagem}") 
        public String exibirFormularioEdicao(@PathVariable("idPassagem") Long userIdPassagem, Model model) {
            Passagem passagem = passagemService.getPassagemById(userIdPassagem);
            model.addAttribute("passagem", passagem);
            return "editarPassagem"; 
        }


        @PostMapping("/editarPassagem/{idPassagem}")
        public String editUser(@PathVariable("idPassagem") Long userIdPassagem, @ModelAttribute("passagem") Passagem passagem) {
            Passagem passagemExistente = passagemService.getPassagemById(userIdPassagem);

            passagemExistente.setOrigem(passagem.getOrigem());
            passagemExistente.setDestino(passagem.getDestino());
            passagemExistente.setDataIda(passagem.getDataIda());
            passagemExistente.setDataVolta(passagem.getDataVolta());
            passagemExistente.setAgencia(passagem.getAgencia());
            passagemExistente.setQuantidadeLugares(passagem.getQuantidadeLugares());



            passagemService.updatePassagem(userIdPassagem, passagemExistente); 

            return "redirect:/passagens"; 
        }
		
		// EXCLUIR CATEGORIA
		@GetMapping("/deletar/{idPassagem}")
		public String deletePassagem(@PathVariable Long idPassagem) {
			passagemService.deletePassagem(idPassagem);
			return "redirect:/passagens";
		}
	}

