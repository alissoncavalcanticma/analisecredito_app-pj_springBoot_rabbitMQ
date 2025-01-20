package com.ctfera.analisecredito.service.strategy.impl;

import com.ctfera.analisecredito.domain.Proposta;
import com.ctfera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NomeNegativoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
       if(nomeNegativado()){
           throw new RuntimeException("Nome negativado");
       }
        return 100;
    }

    private boolean nomeNegativado(){
        return new Random().nextBoolean();
    }
}
