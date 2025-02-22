package com.ctfera.analisecredito.service.strategy.impl;

import com.ctfera.analisecredito.constantes.MensagemConstante;
import com.ctfera.analisecredito.domain.Proposta;
import com.ctfera.analisecredito.exceptions.StrategyException;
import com.ctfera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

//Annotation para ordenar instanciação pelo spring
@Order(1)
@Component
public class NomeNegativadoImpl implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
       if(nomeNegativado()){
           throw new StrategyException(String.format(MensagemConstante.CLIENTE_NEGATIVADO, proposta.getUsuario().getNome()));
       }
        return 100;
    }

    private boolean nomeNegativado(){
        return new Random().nextBoolean();
    }
}
