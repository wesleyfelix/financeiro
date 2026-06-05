package br.com.avaliacao.financeiro.service;

import br.com.avaliacao.financeiro.dto.TransferenciaRequest;
import br.com.avaliacao.financeiro.dto.TransferenciaResponse;
import br.com.avaliacao.financeiro.entity.Transferencia;
import br.com.avaliacao.financeiro.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final TaxaService taxaService;

    public TransferenciaService(TransferenciaRepository transferenciaRepository,
                                TaxaService taxaService) {
        this.transferenciaRepository = transferenciaRepository;
        this.taxaService = taxaService;
    }

    public TransferenciaResponse agendar(TransferenciaRequest request) {
        LocalDate dataAgendamento = LocalDate.now();

        Transferencia transferencia = new Transferencia();
        transferencia.setContaOrigem(request.getContaOrigem());
        transferencia.setContaDestino(request.getContaDestino());
        transferencia.setValor(request.getValor());
        transferencia.setDataTransferencia(request.getDataTransferencia());
        transferencia.setDataAgendamento(dataAgendamento);

        transferencia.setTaxa(
                taxaService.calcular(
                        request.getValor(),
                        dataAgendamento,
                        request.getDataTransferencia()
                )
        );

        Transferencia salva = transferenciaRepository.save(transferencia);

        return toResponse(salva);
    }

    public List<TransferenciaResponse> listar() {
        return transferenciaRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    private TransferenciaResponse toResponse(Transferencia transferencia) {
        return new TransferenciaResponse(
                transferencia.getId(),
                transferencia.getContaOrigem(),
                transferencia.getContaDestino(),
                transferencia.getValor(),
                transferencia.getTaxa(),
                transferencia.getDataTransferencia(),
                transferencia.getDataAgendamento()
        );
    }
}