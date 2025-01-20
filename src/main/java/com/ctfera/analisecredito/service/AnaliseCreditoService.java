package com.ctfera.analisecredito.service;

import com.ctfera.analisecredito.domain.Proposta;
import com.ctfera.analisecredito.exceptions.StrategyException;
import com.ctfera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {


    //List para iniciar todas as implementações de calculoPonto
    @Autowired
    private List<CalculoPonto> calculoPontoList;

//    public AnaliseCreditoService(List<CalculoPonto> calculoPontoList){
//        this.calculoPontoList = calculoPontoList;
//    }

    public void analisar(Proposta proposta){
      try{
          boolean aprovada = calculoPontoList.stream()
                  .mapToInt(impl -> impl.calcular(proposta)).sum() > 350;
          proposta.setAprovada(aprovada);
      }catch(StrategyException e){
          proposta.setAprovada(false);
      }
    }
}
