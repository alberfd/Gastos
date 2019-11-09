package com.alberto.gastos.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codCategoria;

    private String txtNombre;

    @ManyToMany(mappedBy = "categorias")
    @JsonIgnore
    private List<Operacion> operacions;

    @ManyToMany(mappedBy = "categorias")
    @JsonIgnore
    private List<GastoFijo> gastosFijos;




}
