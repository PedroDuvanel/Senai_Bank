package com.senaibank.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senaibank.bank.classes.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {


    
}