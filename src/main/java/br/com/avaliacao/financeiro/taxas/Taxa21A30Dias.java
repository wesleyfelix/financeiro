package br.com.avaliacao.financeiro.taxas;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Taxa21A30Dias implements Taxa {

    @Override
    public boolean aceita(long dias) {
        return dias >= 21 && dias <= 30;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.069"));
    }
}