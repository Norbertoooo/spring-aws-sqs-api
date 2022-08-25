package com.vitu.controller;

import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.vitu.service.SqsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fila")
public class SqsController {

    private final Logger log = LoggerFactory.getLogger(SqsController.class);
    private final SqsService sqsService;

    public SqsController(SqsService sqsService) {
        this.sqsService = sqsService;
    }

    @GetMapping
    public ListQueuesResult listar() {
        log.info("Requisição para listar filas");
        return sqsService.listar();
    }

    @PostMapping
    public void criar(@RequestParam String nome) {
        log.info("Requisição para criar fila: {}", nome);
        sqsService.criar(nome);
    }

    @DeleteMapping
    public void deletar(@RequestParam String nome) {
        log.info("Requisição para deletar fila: {}", nome);
        sqsService.deletar(nome);
    }
}
