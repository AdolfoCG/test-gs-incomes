package com.adolfo.test.gs.incomes.service;

import org.springframework.stereotype.Service;

import com.adolfo.test.gs.incomes.dto.IncomesDto;
import com.adolfo.test.gs.incomes.entities.Movimiento;

@Service
public interface IncomesService {
    public Movimiento newMovimiento(IncomesDto income);
}
