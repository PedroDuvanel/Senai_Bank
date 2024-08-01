package com.senaibank.bank.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.senaibank.bank.classes.Transacoes;

public interface TransacoesRepository extends JpaRepository <Transacoes, Long> {

}
