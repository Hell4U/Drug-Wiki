package com.promition.drugwiki.entity;

import javax.persistence.*;

@Entity
@Table(name="brandgenerics")
public class BrandGeneric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This will act as the row no.
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    private Generic generic;
}
