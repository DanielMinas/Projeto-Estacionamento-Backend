package com.project.estacionamento.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.stereotype.Service;

import com.project.estacionamento.models.EstacionamentoModel;
import com.project.estacionamento.repositories.EstacionamentoRepository;


@Service
public class EstacionamentoService {

	
	final EstacionamentoRepository estacionamentoRepository;
	
	
	public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
		this.estacionamentoRepository = estacionamentoRepository;
	}

	@Transactional
	public EstacionamentoModel save(EstacionamentoModel estacionamentoModel) {
		
		return estacionamentoRepository.save(estacionamentoModel);
	}



	public Optional<EstacionamentoModel> findById(long id) {
		return estacionamentoRepository.findById(id);
	}

	@Transactional
	public void delete(EstacionamentoModel estacionamentoModel) {
		estacionamentoRepository.delete(estacionamentoModel);
		
	}

	public List<EstacionamentoModel>findAll() {
		// TODO Auto-generated method stub
		return estacionamentoRepository.findAll();
	}
	  

}
