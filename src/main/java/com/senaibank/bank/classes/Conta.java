package com.senaibank.bank.classes;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "conta")
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroConta;

    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente titular;

    @Column(nullable = false)
    private String saldo;

    

}