package com.promition.drugwiki.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "companies")
@Data
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 1000)
    private String address;

    @Email
    private String email;

    private String phone;

    private String fax;

    private String website;

}
