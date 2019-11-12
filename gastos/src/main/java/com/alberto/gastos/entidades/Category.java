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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codCategoria;

    private String txtNombre;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Operation> operations;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<FixedOperation> gastosFijos;

    @ManyToOne
    @JoinColumn(name = "codPadre")
    private Category fatherCategory;

    @OneToMany(mappedBy = "fatherCategory")
    private List<Category> subCategories;



}
