package com.ctfera.analisecredito.listener;

import com.ctfera.analisecredito.domain.Proposta;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropostaEmAnaliseListener {

    @RabbitListener(queues = "${proposta-pendente.ms-analise-credito}")
    public void propostaEmAnalise(Proposta proposta){

    }
}
