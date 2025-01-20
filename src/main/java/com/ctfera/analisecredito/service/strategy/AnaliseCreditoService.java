package com.ctfera.analisecredito.service.strategy;

import com.ctfera.analisecredito.domain.Proposta;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseCreditoService {


    //List para iniciar todas as implementações de calculoPonto
    private List<CalculoPonto> calculoPontoList;

    public AnaliseCreditoService(List<CalculoPonto> calculoPontoList){
        this.calculoPontoList = calculoPontoList;
    }

    public void analisar(Proposta proposta){
       int pontuacao =  calculoPontoList.stream().mapToInt(impl -> impl.calcular(proposta)).sum();
    }
}
