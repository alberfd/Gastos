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
@Table(name = "gastos")
public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codGasto;

    private String txtConcepto;

    private String txtNota;

    private int indTipo;

    private float numCantidad;

    private LocalDateTime datFecha;

    @ManyToMany
    @JoinTable(
            name = "gastos_categorias",
            joinColumns = @JoinColumn(name = "codGasto"),
            inverseJoinColumns = @JoinColumn(name = "codCategoria"))
    private List<Categoria> categorias;



}
