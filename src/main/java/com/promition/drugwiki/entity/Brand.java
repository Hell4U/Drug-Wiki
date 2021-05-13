package com.promition.drugwiki.entity;

import com.promition.drugwiki.constant.Type;
import com.promition.drugwiki.constant.TypeUnit;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="brands")
@Data
public class Brand {
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
}
