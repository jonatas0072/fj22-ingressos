package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoTests {
	@Test
	public void oPrecoDaSessaoDeveSerIgualASomaPoPrecoDaSalaMaisOPrecoDoFilme() {

		Sala sala = new Sala("Eldorado - IMax", new BigDecimal("22.5"));
		Filme filme = new Filme("Roque One", Duration.ofMinutes(120), "SCI-FI", new BigDecimal("25.5"));

		BigDecimal somaDosPrecosDaSalaEFilme = sala.getPreco().add(filme.getPreco());

		Sessao sessao = new Sessao(LocalTime.parse("11:00:00"), filme, sala);

		Assert.assertEquals(somaDosPrecosDaSalaEFilme, sessao.getPreco());

	}
}
