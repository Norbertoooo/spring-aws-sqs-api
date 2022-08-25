package com.vitu.producer;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitu.domain.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PedidoProducer {

    private final Logger log = LoggerFactory.getLogger(PedidoProducer.class);

    @Value("${cloud.aws.end-point.uri}")
    private String filaPedidoUri;

    @Autowired
    AmazonSQSAsync amazonSQSAsync;

    public void enviar(Pedido pedido) throws JsonProcessingException {
        log.info("Enviando pedido: {} para a fila: {}", pedido, filaPedidoUri);
        amazonSQSAsync.sendMessageAsync(filaPedidoUri, new ObjectMapper().writeValueAsString(pedido));
    }

}
