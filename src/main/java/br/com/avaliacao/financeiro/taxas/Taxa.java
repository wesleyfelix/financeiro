package br.com.avaliacao.financeiro.taxas;

import java.math.BigDecimal;

public interface Taxa {

    boolean aceita(long dias);

    BigDecimal calcular(BigDecimal valor);
}

