package com.ceiba.estacionamiento;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ceiba.estacionamiento.dominio.services.ParquimetroService;

@SpringBootTest
class EstacionamientoApplicationTests {

	private static final long VALOR_MINUTO = 99L;
	
	@Test
	void calculoValorParquimetro() {
		final LocalDateTime ingreso = LocalDateTime.of(2020, 10, 9, 11, 50);
		final LocalDateTime salida = LocalDateTime.of(2020, 10, 9, 12, 15);
		final long minutes = 25;
		
		final ParquimetroService parquimetroService = new ParquimetroService(ingreso, salida);
		final long valor = parquimetroService.calcularValorPagar();
		
		Assert.assertEquals((minutes * VALOR_MINUTO), valor);
	}

}
