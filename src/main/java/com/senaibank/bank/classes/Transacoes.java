package com.senaibank.bank.classes;

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
@Table(name = "transacoes")
public class Transacoes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroTransacao;

    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente remetente;

    @OneToOne
    @JoinColumn(nullable = false)
    private Cliente destinatario;

    @Column(nullable = false)
    private String saldoEnviado;


}
