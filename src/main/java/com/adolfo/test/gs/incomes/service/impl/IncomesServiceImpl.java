package com.adolfo.test.gs.incomes.service.impl;

import org.springframework.stereotype.Service;

import com.adolfo.test.gs.incomes.dto.IncomesDto;
import com.adolfo.test.gs.incomes.entities.Movimiento;
import com.adolfo.test.gs.incomes.service.IncomesService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class IncomesServiceImpl implements IncomesService {
    
    @Override
    public Movimiento newMovimiento(IncomesDto income) {
        
        return null;
    }
}
