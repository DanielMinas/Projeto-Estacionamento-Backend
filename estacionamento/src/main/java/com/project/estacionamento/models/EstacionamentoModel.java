package com.project.estacionamento.models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Tbl_movimentacao")
public class EstacionamentoModel{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, unique =true, length = 8)
	private String placa;
	@Column(nullable = false, length = 50)
	private String modelo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column ()
	private  LocalDate data_entrada;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column ()
	private LocalDate data_saida;
	@JsonFormat(pattern = "hh:mm")
	@Column (nullable = true)
	private Time tempo;
	@Column(nullable = true, length = 20)
	private Double valor_pago;
	@Column()
	private Double valor_primeira_hora;
	@Column()
	private Double valor_demais_hora;
	@Column()
	private Boolean nao_estacionado;
	@JsonFormat(pattern = "hh:mm")
	@Column ()
	private  LocalTime hora_entrada;
	@JsonFormat(pattern = "hh:mm")
	@Column()
	private  LocalTime hora_saida;
	

	public Boolean getNao_estacionado() {
		return nao_estacionado;
	}
	public void setNao_estacionado(Boolean nao_estacionado) {
		this.nao_estacionado = nao_estacionado;
	}
	public LocalTime getHora_entrada() {
		return hora_entrada;
	}
	public void setHora_entrada(LocalTime hora_entrada) {
		this.hora_entrada = hora_entrada;
	}
	public LocalTime getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(LocalTime hora_saida) {
		this.hora_saida = hora_saida;
	}
	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}
	public void setData_saida(LocalDate data_saida) {
		this.data_saida = data_saida;
	}
	
	public Double getValor_primeira_hora() {
		return valor_primeira_hora;
	}
	public void setValor_primeira_hora(Double valor_primeira_hora) {
		this.valor_primeira_hora = valor_primeira_hora;
	}
	public Double getValor_demais_hora() {
		return valor_demais_hora;
	}
	public void setValor_demais_hora(Double valor_demais_hora) {
		this.valor_demais_hora = valor_demais_hora;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public LocalDate getData_entrada() {
		return data_entrada;
	}
	public LocalDate getData_saida() {
		return data_saida;
	}
	public Time getTempo() {
		return tempo;
	}
	public void setTempo(Time tempo) {
		this.tempo = tempo;
	}
	public Double getValor_pago() {
		return valor_pago;
	}
	public void setValor_pago(Double valor_pago) {
		this.valor_pago = valor_pago;
	}
	
	
	

	
	
	
	
}
