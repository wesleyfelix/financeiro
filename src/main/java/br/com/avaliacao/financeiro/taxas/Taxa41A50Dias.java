package br.com.avaliacao.financeiro.taxas;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Taxa41A50Dias implements Taxa {

    @Override
    public boolean aceita(long dias) {
        return dias >= 41 && dias <= 50;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.017"));
    }
}