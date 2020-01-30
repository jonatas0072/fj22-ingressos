package br.com.caelum.ingresso.desconto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class DescontoTest {

	private Sala sala;
	private Filme filme;

	@Before
	public void preparandoAmbiente() {
		this.sala = new Sala("Eldorado - IMax", new BigDecimal("25"));
		this.filme = new Filme("Rogue One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("25.00"));

	}

	@Test
	public void naoDeveConcederDescontoParaIngressoNormal() {
		Lugar lugar = new Lugar("A", 1);
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.INTEIRO, lugar);

		BigDecimal precoEsperado = new BigDecimal("50.00");

		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoDeEstudante() {
		Lugar lugar = new Lugar("A", 2);
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.ESTUDANTE, lugar);

		BigDecimal precoEsperado = new BigDecimal("25.00");

		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoDeIdoso() {
		Lugar lugar = new Lugar("A", 3);
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, TipoDeIngresso.IDOSO, lugar);

		BigDecimal precoEsperado = new BigDecimal("20.00");

		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

}
