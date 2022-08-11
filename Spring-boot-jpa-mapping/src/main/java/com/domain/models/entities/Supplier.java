package com.domain.models.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_suppliers")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(length = 100, nullable = false)
    @Getter
    @Setter
    private String name;

    @Column(length = 150, nullable = false)
    @Getter
    @Setter
    private String address;

    @Column(length = 100, nullable = false)
    @Getter
    @Setter
    private String email;

    @ManyToMany(mappedBy = "suppliers")
    @Getter
    @Setter
    private Set<Product> products;
}
