package com.ctfera.analisecredito.listener;

import com.ctfera.analisecredito.domain.Proposta;
import com.ctfera.analisecredito.service.AnaliseCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropostaEmAnaliseListener {

    @Autowired
    private AnaliseCreditoService analiseCreditoService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(Proposta proposta){

        analiseCreditoService.analisar(proposta);
    }
}
