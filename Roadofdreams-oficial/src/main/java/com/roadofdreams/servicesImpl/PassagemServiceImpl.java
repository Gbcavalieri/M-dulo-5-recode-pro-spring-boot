package com.roadofdreams.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roadofdreams.model.Passagem;
import com.roadofdreams.repositories.PassagemRepository;
import com.roadofdreams.services.PassagemService;





	@Service
	public class PassagemServiceImpl implements PassagemService {

		@Autowired
		private PassagemRepository passagemRepository;
		
		@Override
		public List<Passagem> getAllPassagens() {
			return passagemRepository.findAll();
		}

		@Override
		public Passagem getPassagemById(Long idPassagem) {
			return passagemRepository.findById(idPassagem).orElse(null);
		}

		@Override
		public Passagem savePassagem(Passagem passagem) {
		return passagemRepository.save(passagem);
		}

		@Override
		public Passagem updatePassagem(Long idPassagem, Passagem PassagemAtualizada) {
	    Passagem passagemExistente = passagemRepository.findById(idPassagem).orElse(null);
	    if (passagemExistente != null);
	    passagemExistente.setOrigem(PassagemAtualizada.getOrigem());
	    passagemExistente.setDestino(PassagemAtualizada.getDestino());
	    passagemExistente.setDataIda(PassagemAtualizada.getDataIda());
	    passagemExistente.setDataVolta(PassagemAtualizada.getDataVolta());
	    passagemExistente.setAgencia(PassagemAtualizada.getAgencia());
	    passagemExistente.setQuantidadeLugares(PassagemAtualizada.getQuantidadeLugares());
	    return passagemRepository.save(passagemExistente);
		}

		@Override
		public void deletePassagem(Long idPassagem) {
			passagemRepository.deleteById(idPassagem);
			
		}
	
}
