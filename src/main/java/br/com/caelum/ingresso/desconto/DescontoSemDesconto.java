package br.com.caelum.ingresso.desconto;

import java.math.BigDecimal;

public class DescontoSemDesconto implements Desconto {

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal;
	}

	@Override
	public String getDescricao() {
		return "Normal";
	}
}
