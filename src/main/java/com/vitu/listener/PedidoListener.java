package com.vitu.listener;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {


    @Autowired
    AmazonSQSAsync amazonSQSAsync;

}
