package com.ctfera.analisecredito.service.strategy.impl;

import com.ctfera.analisecredito.domain.Proposta;
import com.ctfera.analisecredito.service.strategy.CalculoPonto;

public class PrazoPagamentoInferiorDezAnos implements CalculoPonto {

    @Override
    public int calcular(Proposta proposta) {
        return proposta.getPrazoPagamento() > 120 ? 80 : 0;
    }
}
