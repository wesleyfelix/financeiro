package br.com.avaliacao.financeiro.taxas;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxaMesmoDia implements Taxa {

    @Override
    public boolean aceita(long dias) {
        return dias == 0;
    }

    @Override
    public BigDecimal calcular(BigDecimal valor) {
        BigDecimal taxaFixa = new BigDecimal("3.00");
        BigDecimal taxaPercentual = valor.multiply(new BigDecimal("0.025"));
        return taxaFixa.add(taxaPercentual);
    }
}

