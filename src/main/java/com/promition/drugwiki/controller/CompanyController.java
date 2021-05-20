package com.promition.drugwiki.controller;

import com.promition.drugwiki.entity.Company;
import com.promition.drugwiki.entity.Generic;
import com.promition.drugwiki.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<Company> create (@Valid @RequestBody Company company) throws URISyntaxException {
       company = companyService.save(company);

        return ResponseEntity.created(new URI("/api/companies/" + company.getId())).body(company);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll() throws URISyntaxException {
        List<Company> company=companyService.findAll();

        return ResponseEntity.created(new URI("/api/companies")).body(company);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> findById(@Valid @PathVariable(name="id") Long id) throws URISyntaxException {
        Optional<Company> company=companyService.findOne(id);
        return ResponseEntity.created(new URI("/api/generics/"+company.get().getId())).body(company);
    }

    @DeleteMapping("/{id}")
    public List<String> deleteById(@Valid @PathVariable(name = "id") Long id){
        companyService.delete(id);
        return List.of("Id has been deleted");
    }
}
