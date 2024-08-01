package com.senaibank.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senaibank.bank.classes.Conta;
import com.senaibank.bank.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<Conta>> getAll() {
        List<Conta> contas = contaService.getAll();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{conta}")
    public ResponseEntity<Conta> getById(@PathVariable Long id) {
        Conta conta = contaService.getById(id);
        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conta);
    }

    @PostMapping
    public ResponseEntity<Conta> create(@RequestBody Conta conta) {
        Conta contaSalva = contaService.create(conta);
        return ResponseEntity.status(201).body(contaSalva); 
    }

    @PutMapping("/{conta}")
    public ResponseEntity<Conta> update(@PathVariable Long id, @RequestBody Conta conta) {
        Conta contaAtualizada = contaService.update(id, conta);
        if (contaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contaAtualizada);
    }

    @DeleteMapping("/{conta}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Conta conta = contaService.getById(id);
        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        contaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
