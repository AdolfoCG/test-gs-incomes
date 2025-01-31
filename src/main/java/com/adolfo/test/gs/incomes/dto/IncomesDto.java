package com.adolfo.test.gs.incomes.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncomesDto {
    private int tipoMovimiento;
    private float monto;
    private String empleado;
}
