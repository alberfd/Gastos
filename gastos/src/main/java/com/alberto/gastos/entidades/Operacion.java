package com.alberto.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operaciones")
public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codOperacion;

    private String txtConcepto;

    private String txtNota;

    private int indTipo;

    private float numCantidad;

    private LocalDateTime datFecha;

    @ManyToOne
    @JoinColumn(name = "codCategoria")
    private Categoria categoria;



}
