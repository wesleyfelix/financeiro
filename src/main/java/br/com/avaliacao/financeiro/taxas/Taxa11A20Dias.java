package br.com.avaliacao.financeiro.taxas;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Taxa11A20Dias implements Taxa {

    @Override
    public boolean aceita(long dias) {
        return dias >= 11 && dias <= 20;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.082"));
    }
}