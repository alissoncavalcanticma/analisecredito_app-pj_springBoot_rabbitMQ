package com.ctfera.analisecredito.service;

import com.ctfera.analisecredito.domain.Proposta;
import com.ctfera.analisecredito.exceptions.StrategyException;
import com.ctfera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {


    //List para iniciar todas as implementações de calculoPonto
    @Autowired
    private List<CalculoPonto> calculoPontoList;

    @Autowired
    private NotificacaoRabbitService notificacaoRabbitService;

    @Value("${rabbitmq.exchange.proposta.concluida}")
    private String exchangePropostaConcluida;

//    public AnaliseCreditoService(List<CalculoPonto> calculoPontoList){
//        this.calculoPontoList = calculoPontoList;
//    }

    public void analisar(Proposta proposta){
      try{
          int pontos = calculoPontoList.stream()
                  .mapToInt(impl -> impl.calcular(proposta)).sum();
          //Será true ou false, de acordo com resultado da proposição lógica abaixo.
          proposta.setAprovada(pontos > 350);
      }catch(StrategyException e){
          proposta.setAprovada(false);
          proposta.setObservacao(e.getMessage());
      }
      notificacaoRabbitService.notificar(exchangePropostaConcluida, proposta);
    }
}
