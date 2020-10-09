package com.ceiba.estacionamiento.dominio.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ParquimetroService {

	private static final long VALOR_MINUTO = 99L;
	
	private LocalDateTime fechaIngreso;
	private LocalDateTime fechaSalida;
	
	public ParquimetroService(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
		if(fechaIngreso == null || fechaSalida == null) {
			throw new IllegalArgumentException("Fecha de Ingreso y Fecha de Salida son requeridos");
		}
		
		if(fechaIngreso.isAfter(fechaSalida)) {
			throw new IllegalArgumentException("Fecha Ingreso no puede ser mayor a Fecha Salida");
		}
		
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
	}
	
	public long calcularValorPagar() {
		final long minutes = this.fechaIngreso.until(this.fechaSalida, ChronoUnit.MINUTES);
		return (VALOR_MINUTO * minutes);
	}
	
}
