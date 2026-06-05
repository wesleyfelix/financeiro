package br.com.avaliacao.financeiro.service;

import br.com.avaliacao.financeiro.exception.RegraNegocioException;
import br.com.avaliacao.financeiro.taxas.Taxa;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TaxaService {

    private final List<Taxa> strategies;

    public TaxaService(List<Taxa> strategies) {
        this.strategies = strategies;
    }

    public BigDecimal calcular(BigDecimal valor, LocalDate dataAgendamento, LocalDate dataTransferencia) {
        long dias = ChronoUnit.DAYS.between(dataAgendamento, dataTransferencia);

        return strategies.stream()
                .filter(strategy -> strategy.aceita(dias))
                .findFirst()
                .orElseThrow(() -> new RegraNegocioException("Não há taxa aplicável para a data informada"))
                .calcular(valor);
    }
}