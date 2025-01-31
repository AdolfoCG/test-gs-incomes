package com.adolfo.test.gs.incomes.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adolfo.test.gs.incomes.dto.IncomesDto;
import com.adolfo.test.gs.incomes.entities.Empleado;
import com.adolfo.test.gs.incomes.entities.LimiteCaja;
import com.adolfo.test.gs.incomes.entities.Movimiento;
import com.adolfo.test.gs.incomes.repositories.EmpleadoRepository;
import com.adolfo.test.gs.incomes.repositories.LimiteCajaRepository;
import com.adolfo.test.gs.incomes.repositories.MovimientoRepository;
import com.adolfo.test.gs.incomes.service.IncomesService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class IncomesServiceImpl implements IncomesService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private LimiteCajaRepository limiteCajaRepository;


    @Override
    @Transactional
    public Optional<Movimiento> newIncome(IncomesDto income) {
        Optional<Empleado> optionalEmpleado = empleadoRepository.findByNombre(income.getEmpleado());
        Movimiento ingreso = new Movimiento();

        if (optionalEmpleado.isPresent()) {
            Empleado empleado = optionalEmpleado.orElseThrow();
            float limiteEmpleado = limiteEmpleadoFunc(empleado);

            if (limiteEmpleado != 0) {
                float saldoActual = empleado.getSaldoActual();
                float cuenta = saldoActual + income.getMonto();

                if (cuenta <= limiteEmpleado) {
                    ingreso.setTipoMovimiento(1);
                    ingreso.setMonto(income.getMonto()); 
                    ingreso.setFecha(new Date());
                    ingreso.setEmpleado(empleado);

                    empleado.setSaldoActual(cuenta);
                    empleadoRepository.save(empleado);

                    return Optional.of(movimientoRepository.save(ingreso));
                }
            }
        }
        
        return Optional.of(ingreso);
    }

    private float limiteEmpleadoFunc(Empleado empleado) {
        Optional<LimiteCaja> limiteCaja = limiteCajaRepository.findByEmpleado(empleado);
        float limiteEmpleado = 0;
            
            if (limiteCaja.isPresent()) {
                limiteEmpleado = limiteCaja.get().getMontoMaximo();
            }

        return limiteEmpleado;
    }
}
