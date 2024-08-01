package com.senaibank.bank.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.bank.classes.Conta;

public interface ContaRepository extends JpaRepository <Conta, Long> {

}
