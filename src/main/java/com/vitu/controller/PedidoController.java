package com.vitu.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vitu.domain.Pedido;
import com.vitu.producer.PedidoProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {

    private final PedidoProducer pedidoProducer;

    public PedidoController(PedidoProducer pedidoProducer) {
        this.pedidoProducer = pedidoProducer;
    }

    @PostMapping
    public void enviar(@RequestBody Pedido pedido) throws JsonProcessingException {
        pedidoProducer.enviar(pedido);
    }
}
