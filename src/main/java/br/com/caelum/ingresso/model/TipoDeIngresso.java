package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.desconto.Desconto;
import br.com.caelum.ingresso.desconto.DescontoParaEstudante;
import br.com.caelum.ingresso.desconto.DescontoParaIdoso;
import br.com.caelum.ingresso.desconto.DescontoSemDesconto;

public enum TipoDeIngresso {

	INTEIRO(new DescontoSemDesconto()), ESTUDANTE(new DescontoParaEstudante()), IDOSO(new DescontoParaIdoso());

	private final Desconto desconto;

	TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}

	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDescontoSobre(valor);
	}

	public String getDescricao() {
		return desconto.getDescricao();
	}
}
