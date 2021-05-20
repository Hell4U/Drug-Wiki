package com.promition.drugwiki.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.promition.drugwiki.constant.Type;
import com.promition.drugwiki.constant.TypeUnit;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="brands")
@Data
public class Brand extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private double packageUnit;

    @Column(nullable = false)
    private double pricePerUnit;

    @ManyToOne(fetch = FetchType.EAGER)
    private Company company;

    @Column(nullable = false)
    private LocalDate launchDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeUnit typeUnit;

    @JsonBackReference
    @ManyToMany
    @JoinTable(name = "brand_generics",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "generic_id")
    )
    private List<Generic> generics;
}
