package com.promition.drugwiki.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "companies")
@Data
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 1000)
    private String address;

    private String email;

    private String phone;

    private String fax;

    private String website;

}
