package com.project.estacionamento.controllers;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.estacionamento.dtos.EstacionamentoDto;
import com.project.estacionamento.models.EstacionamentoModel;
import com.project.estacionamento.services.EstacionamentoService;


/**
 * @author Daniel
 *
 */
@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping("/estacionamento")
public class EstacionamentoController {

	final EstacionamentoService estacionamentoService;
	
	public EstacionamentoController(EstacionamentoService estacionamentoService ) {
		this.estacionamentoService = estacionamentoService;
	}
	@PostMapping("/add")
	public ResponseEntity<Object> saveEstacionamento( @Valid @RequestBody EstacionamentoDto estacionamentoDto){
		var estacionamentoModel = new EstacionamentoModel();
		BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
		estacionamentoModel.setData_entrada(LocalDate.now(ZoneId.of("UTC-3")));
		estacionamentoModel.setHora_entrada(LocalTime.now(ZoneId.of("UTC-3")));
		estacionamentoModel.setHora_saida(LocalTime.now(ZoneId.of("UTC-3")));
		estacionamentoModel.setValor_primeira_hora(Double.valueOf(6));	
		estacionamentoModel.setValor_demais_hora(Double.valueOf(4));
		estacionamentoModel.setNao_estacionado(Boolean.valueOf(false));
		  estacionamentoModel.setData_saida(LocalDate.now(ZoneId.of("UTC-3")));
		return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoService.save(estacionamentoModel));	
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<EstacionamentoModel>> getEstacionamento(){
		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.findAll());
	}

	  @GetMapping("/get/{id}")
	    public ResponseEntity<Object> getOneEstacionamento(@PathVariable(value = "id") long id){
	        Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
	        if (!estacionamentoModelOptional.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoModelOptional.get());
	    }
	
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEstacionamento(@PathVariable(value = "id") long id){
        Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
        if (!estacionamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        estacionamentoService.delete(estacionamentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }
    
    @PutMapping("/put/{id}")
    public ResponseEntity<Object> updateEstacionamento(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid EstacionamentoDto estacionamentoDto){
        Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
        if (!estacionamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        var estacionamentoModel = new EstacionamentoModel();
        BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
        estacionamentoModel.setId(estacionamentoModelOptional.get().getId());
        estacionamentoModel.setHora_entrada(estacionamentoModelOptional.get().getHora_entrada());
        estacionamentoModel.setData_entrada(estacionamentoModelOptional.get().getData_entrada());
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.save(estacionamentoModel));
    }
    
    @PutMapping("/putSaida/{id}")
    public ResponseEntity<Object> updateEstacionamentoSaida(@PathVariable(value = "id") long id,
                                                    @RequestBody @Valid EstacionamentoDto estacionamentoDto){
        Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
        if (!estacionamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        var estacionamentoModel = new EstacionamentoModel();
        BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
        estacionamentoModel.setId(estacionamentoModelOptional.get().getId());
        estacionamentoModel.setData_saida(estacionamentoModelOptional.get().getData_saida());
        estacionamentoModel.setHora_saida(estacionamentoModelOptional.get().getHora_saida());
        estacionamentoModel.setData_entrada(estacionamentoModelOptional.get().getData_entrada());
        estacionamentoModel.setNao_estacionado(Boolean.valueOf(true));
        estacionamentoModel.setHora_saida(LocalTime.now(ZoneId.of("UTC-3")));
        estacionamentoModel.setData_entrada(estacionamentoModelOptional.get().getData_entrada());
        
      
        
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.save(estacionamentoModel));
    }
    
   
    
    
    
   
}
