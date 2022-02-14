package com.project.estacionamento.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
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
	@PostMapping
	public ResponseEntity<Object> saveEstacionamento( @Valid @RequestBody EstacionamentoDto estacionamentoDto){
		var estacionamentoModel = new EstacionamentoModel();
		BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
		estacionamentoModel.setData_entrada(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoService.save(estacionamentoModel));	
	}
	
	@GetMapping
	public ResponseEntity<Page<EstacionamentoModel>> getEstacionamento(@PageableDefault(page=0, size =10, sort= "id", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.findAll(pageable));
	}

	  @GetMapping("/{id}")
	    public ResponseEntity<Object> getOneEstacionamento(@PathVariable(value = "id") UUID id){
	        Optional<EstacionamentoModel> parkingSpotModelOptional = estacionamentoService.findById(id);
	        if (!parkingSpotModelOptional.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
	        }
	        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
	    }
	
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEstacionamento(@PathVariable(value = "id") UUID id){
        Optional<EstacionamentoModel> estacionamentoModelOptional = estacionamentoService.findById(id);
        if (!estacionamentoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        System.out.println(estacionamentoModelOptional.get());
        estacionamentoService.delete(estacionamentoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully.");
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEstacionamento(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid EstacionamentoDto estacionamentoDto){
        Optional<EstacionamentoModel> parkingSpotModelOptional = estacionamentoService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        var estacionamentoModel = new EstacionamentoModel();
        BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
        estacionamentoModel.setId(parkingSpotModelOptional.get().getId());
        estacionamentoModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.save(estacionamentoModel));
    }
}
