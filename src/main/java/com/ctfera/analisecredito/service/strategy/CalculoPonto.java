package com.ctfera.analisecredito.service.strategy;

import com.ctfera.analisecredito.domain.Proposta;

public interface CalculoPonto {
    int calcular(Proposta proposta);
}
