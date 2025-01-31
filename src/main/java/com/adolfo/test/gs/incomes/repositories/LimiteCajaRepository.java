package com.adolfo.test.gs.incomes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adolfo.test.gs.incomes.entities.LimiteCaja;

@Repository
public interface LimiteCajaRepository extends JpaRepository<LimiteCaja, Long> {

}
