package com.alberto.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operaciones")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codOperacion;

    private String txtConcepto;

    private String txtNota;

    private short indTipo;

    private float numCantidad;

    private LocalDateTime datFecha;

    @ManyToOne
    @JoinColumn(name = "codCategoria")
    private Category category;



}
