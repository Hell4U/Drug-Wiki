package com.promition.drugwiki.controller;

import com.promition.drugwiki.entity.Company;
import com.promition.drugwiki.entity.Generic;
import com.promition.drugwiki.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public ResponseEntity<Page<Company>> getAll(Pageable pageable) throws URISyntaxException {

        if(pageable == null)  {
            pageable = PageRequest.of(0, 1);
        }

        Page<Company> page = companyService.findAll(pageable);
        List<Company> company= page.getContent();

        return ResponseEntity.created(new URI("/api/companies")).body(page);
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

    @PutMapping("/{id}")
    public Company updateById(@PathVariable(name = "id") Long id, @RequestBody Company company){
        company=companyService.update(id,company);
        return company;
    }
}
