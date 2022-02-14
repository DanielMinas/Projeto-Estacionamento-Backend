package com.project.estacionamento.dtos;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class EstacionamentoDto {
	@NotEmpty
	 @Size(max = 7)
    private String placa;
	@NotEmpty
    private String modelo;
	
    private Time tempo;
    
    private Double valor_pago;
    
    
    
    public Double getValor_pago() {
		return valor_pago;
	}
	public void setValor_pago(Double valor_pago) {
		this.valor_pago = valor_pago;
	}
	
    public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Time getTempo() {
		return tempo;
	}
	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}


}
