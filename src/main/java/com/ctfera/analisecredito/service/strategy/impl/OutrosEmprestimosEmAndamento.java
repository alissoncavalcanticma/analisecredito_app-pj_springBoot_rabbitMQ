package com.ctfera.analisecredito.service.strategy.impl;

import com.ctfera.analisecredito.domain.Proposta;
import com.ctfera.analisecredito.service.strategy.CalculoPonto;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OutrosEmprestimosEmAndamento implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta){
        return outrosEmprestimosEmAndamento() ? 0: 80;
    }

    private boolean outrosEmprestimosEmAndamento(){
        return new Random().nextBoolean();
    }
}
