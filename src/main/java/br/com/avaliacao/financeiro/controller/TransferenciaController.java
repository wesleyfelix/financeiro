package br.com.avaliacao.financeiro.controller;

import br.com.avaliacao.financeiro.dto.TransferenciaRequest;
import br.com.avaliacao.financeiro.dto.TransferenciaResponse;
import br.com.avaliacao.financeiro.service.TransferenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
@Validated
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<TransferenciaResponse> agendar(@RequestBody @Valid TransferenciaRequest request) {
        TransferenciaResponse response = transferenciaService.agendar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TransferenciaResponse>> listar() {
        return ResponseEntity.ok(transferenciaService.listar());
    }
}