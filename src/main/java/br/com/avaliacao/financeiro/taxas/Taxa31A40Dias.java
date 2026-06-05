package br.com.avaliacao.financeiro.taxas;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Taxa31A40Dias implements Taxa {

    @Override
    public boolean aceita(long dias) {
        return dias >= 31 && dias <= 40;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(new BigDecimal("0.047"));
    }
}