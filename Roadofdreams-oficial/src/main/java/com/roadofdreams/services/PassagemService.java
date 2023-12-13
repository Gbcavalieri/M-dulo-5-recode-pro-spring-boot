package com.roadofdreams.services;

import java.util.List;

import com.roadofdreams.model.Passagem;



public interface PassagemService {

	
List<Passagem> getAllPassagens ();
	
	Passagem getPassagemById(Long idPassagem);
	
	Passagem savePassagem(Passagem passagem);
	
	Passagem updatePassagem ( Long idPassagem, Passagem PassagemAtualizada);
	
	void deletePassagem(Long idPassagem);
}
