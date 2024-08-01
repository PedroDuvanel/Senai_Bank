package com.senaibank.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senaibank.bank.classes.Transacoes;
import com.senaibank.bank.repository.TransacoesRepository;

@Service
public class TransacoesService {

    @Autowired
    private TransacoesRepository transacoesRepository;

    public List<Transacoes> getAll() {
        return transacoesRepository.findAll();
    }
    
    
    public Transacoes getById(Long id) {
        return transacoesRepository.findById(id).orElse(null);
    }

    public Transacoes create(Transacoes transacoes) {
        return transacoesRepository.save(transacoes);
    }

}
