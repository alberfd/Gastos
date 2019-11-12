package com.alberto.gastos.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operacionesfijas")
public class FixedOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codOperacionFija;

    private String txtConcepto;

    private String txtNota;

    private float numCantidad;

    private short indTipo;

    @ManyToOne
    @JoinColumn(name = "codCategoria")
    private Category category;
}
