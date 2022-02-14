package com.project.estacionamento.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.estacionamento.models.EstacionamentoModel;


@Repository
public interface EstacionamentoRepository extends JpaRepository<EstacionamentoModel, Long>{
	 
	  
}
