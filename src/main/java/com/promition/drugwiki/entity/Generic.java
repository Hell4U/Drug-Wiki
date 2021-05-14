package com.promition.drugwiki.entity;

import com.promition.drugwiki.constant.DosageUnit;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "generics")
@Data
public class Generic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;

    @Column(nullable = false)
    private Double dosage;

    @Enumerated(EnumType.STRING)
    @Column(nullable =false)
    private DosageUnit dosageUnit;

    @ManyToMany(mappedBy = "generics")
    private List<Brand> brands;
}
