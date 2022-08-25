package com.vitu.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SqsService {

    private final Logger log = LoggerFactory.getLogger(SqsService.class);
    private final AmazonSQSAsync amazonSQSAsync;

    public SqsService(AmazonSQSAsync amazonSQSAsync) {
        this.amazonSQSAsync = amazonSQSAsync;
    }

    public ListQueuesResult listar() {
        log.info("Listando filas");
        return amazonSQSAsync.listQueues();
    }

    public void criar(String nome) {
        log.info("Criando fila: {}", nome);
        amazonSQSAsync.createQueueAsync(nome);
    }

    public void deletar(String nome) {
        log.info("Deletando fila: {}", nome);
        amazonSQSAsync.deleteQueue(nome);
    }

}
