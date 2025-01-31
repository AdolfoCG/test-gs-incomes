package com.adolfo.test.gs.incomes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adolfo.test.gs.incomes.dto.IncomesDto;
import com.adolfo.test.gs.incomes.service.IncomesService;

@RestController
@RequestMapping("/movimientos")
public class IncomesController {
    @Autowired
    private IncomesService incomesService;

    @PostMapping("/ingresos")
    public ResponseEntity<?> newIncome(@RequestBody IncomesDto incomes) {
        return incomesService.newIncome(incomes);
    }
}
