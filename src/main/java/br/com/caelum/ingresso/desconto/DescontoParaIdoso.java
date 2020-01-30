package br.com.caelum.ingresso.desconto;

import java.math.BigDecimal;

public class DescontoParaIdoso implements Desconto {

	private final BigDecimal TAXA_DESC0NTO = BigDecimal.valueOf(0.6);

	@Override
	public BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal) {
		return precoOriginal.subtract(aplicandoDesconto(precoOriginal));
	}

	private BigDecimal aplicandoDesconto(BigDecimal precoDesconto) {
		return precoDesconto.multiply(TAXA_DESC0NTO);
	}

	@Override
	public String getDescricao() {
		return "Desconto para Idoso";
	}
}
