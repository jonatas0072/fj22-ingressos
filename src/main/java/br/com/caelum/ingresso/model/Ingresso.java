package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.caelum.ingresso.desconto.Desconto;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco = BigDecimal.ZERO;

	public Ingresso(Sessao sessao, Desconto desconto) {
		this.sessao = sessao;
		this.preco = desconto.aplicarDescontoSobre(sessao.getPreco());
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco.setScale(2, RoundingMode.HALF_UP);
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
