package com.domain.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
public class Product implements Serializable {

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

}
