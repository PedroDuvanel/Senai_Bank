package com.senaibank.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senaibank.bank.classes.Transacoes;
import com.senaibank.bank.service.TransacoesService;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    @Autowired
    private TransacoesService transacoesService;

    @GetMapping
    public ResponseEntity<List<Transacoes>> getAll() {
        List<Transacoes> contas = transacoesService.getAll();
        return ResponseEntity.ok(contas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacoes> getById(@PathVariable Long id) {
        Transacoes transacoes = transacoesService.getById(id);
        if (transacoes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transacoes);
    }

    @PostMapping
    public ResponseEntity<Transacoes> create(@RequestBody Transacoes transacoes) {
        Transacoes transacaoSalva = transacoesService.create(transacoes);
        return ResponseEntity.status(201).body(transacaoSalva); 
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Transacoes> update(@PathVariable Long id, @RequestBody Transacoes transacoes) {
    //     Transacoes transacoesAtualizada = transacoesService.update(id, transacoes);
    //     if (transacoesAtualizada == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     return ResponseEntity.ok(transacoesAtualizada);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> delete(@PathVariable Long id) {
    //     Transacoes transacoes = transacoesService.getById(id);
    //     if (conta == null) {
    //         return ResponseEntity.notFound().build();
    //     }
    //     transacoesService.delete(id);
    //     return ResponseEntity.noContent().build();
    // }
}
