package com.domain.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@RequiredArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @NotEmpty(message = "The name is required")
    @Column(name = "product_name", length = 100)
    @Getter
    @Setter
    private String name;

    @NotEmpty(message = "The description is required")
    @Column(name = "product_description", length = 200)
    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private double price;

    @ManyToOne
    @Getter
    @Setter
    private Category category;

    @ManyToMany
    @JoinTable(
        name = "tbl_suppliers_products",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    @Getter
    @Setter
    private Set<Supplier> suppliers;
}
