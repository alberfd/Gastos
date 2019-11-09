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
@Table(name = "gastos_fijos")
public class GastoFijo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codGastoFijo;

    private String txtConcepto;

    private String txtNota;

    private float numCantidad;

    @ManyToMany
    @JoinTable(
            name = "gastos_fijos_categorias",
            joinColumns = @JoinColumn(name = "codGastoFijo"),
            inverseJoinColumns = @JoinColumn(name = "codCategoria"))
    private List<Categoria> categorias;
}
