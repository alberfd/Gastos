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

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<Operacion> operacions;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnore
    private List<OperacionFija> gastosFijos;

    @OneToOne
    @JoinColumn(name = "codPadre")
    private Categoria categoria;




}
