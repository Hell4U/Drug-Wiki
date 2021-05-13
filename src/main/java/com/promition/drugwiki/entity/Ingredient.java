package com.promition.drugwiki.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@Data
public class Ingredient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String symptoms;
    @Column(length = 1000)
    private String sideEffects;
    @Column(length = 1000)
    private String cautions;
}
