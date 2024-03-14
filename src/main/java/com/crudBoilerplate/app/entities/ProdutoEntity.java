package com.crudBoilerplate.app.entities;

import com.crudBoilerplate.app.coreClasses.genericCrudSuperClasses.CrudGenericEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoEntity extends CrudGenericEntity {
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private BigDecimal valor;
}
