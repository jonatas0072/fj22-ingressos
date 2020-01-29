package br.com.caelum.ingresso.validacao;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.desconto.DescontoParaEstudante;
import br.com.caelum.ingresso.desconto.DescontoParaIdoso;
import br.com.caelum.ingresso.desconto.DescontoSemDesconto;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import junit.framework.Assert;

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
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, new DescontoSemDesconto());

		BigDecimal precoEsperado = new BigDecimal("50.00");

		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoDeEstudante() {
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaEstudante());

		BigDecimal precoEsperado = new BigDecimal("25.00");

		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

	@Test
	public void naoDeveConcederDescontoParaIngressoDeIdoso() {
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		Ingresso ingresso = new Ingresso(sessao, new DescontoParaIdoso());

		BigDecimal precoEsperado = new BigDecimal("20.00");

		Assert.assertEquals(precoEsperado, ingresso.getPreco());
	}

}
