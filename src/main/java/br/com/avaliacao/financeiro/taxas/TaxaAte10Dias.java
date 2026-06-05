package br.com.avaliacao.financeiro.taxas;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxaAte10Dias implements Taxa {

    @Override
    public boolean aceita(long dias) {
        return dias >= 1 && dias <= 10;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return new BigDecimal("12.00");
    }
}