package com.adolfo.test.gs.incomes.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adolfo.test.gs.incomes.dto.IncomesDto;
import com.adolfo.test.gs.incomes.entities.Movimiento;

@Service
public interface IncomesService {
    public Optional<Movimiento> newIncome(IncomesDto income);
}
