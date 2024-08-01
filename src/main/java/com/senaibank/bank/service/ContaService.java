package com.senaibank.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.bank.classes.Conta;
import com.senaibank.bank.repository.ContaRepository;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;
    
    public List<Conta> getAll() {
        return contaRepository.findAll();
    }

    public Conta getById(Long id) {
        return contaRepository.findById(id).orElse(null);
    }

    public Conta update(Long id, Conta novaConta) {
        Conta contaExistente = getById(id);
        if (contaExistente == null) {
            return null;
        }

        contaExistente.setTitular(novaConta.getTitular());
        contaExistente.setSaldo(novaConta.getSaldo());
    
        return contaRepository.save(contaExistente);
    }

    public Conta create(Conta conta) {
        return contaRepository.save(conta);
    }

    public void delete(Long id) {
        Conta contaExistente = getById(id);
        if (contaExistente != null) {
            contaRepository.delete(contaExistente);
        }
    }
}