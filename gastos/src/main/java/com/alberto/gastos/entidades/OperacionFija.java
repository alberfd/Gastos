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
@Table(name = "operacionesfijas")
public class OperacionFija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codOperacionFija;

    private String txtConcepto;

    private String txtNota;

    private float numCantidad;

    @ManyToOne
    @JoinColumn(name = "codCategoria")
    private Categoria categoria;
}
