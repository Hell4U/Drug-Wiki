package com.promition.drugwiki.controller;

import com.promition.drugwiki.entity.Brand;
import com.promition.drugwiki.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Brand> create(@Valid @RequestBody Brand brand) throws URISyntaxException {
        brand=brandService.save(brand);
        return ResponseEntity.created(new URI("/api/brands/"+brand.getId())).body(brand);
    }

    @GetMapping
    public ResponseEntity<List<Brand>> getAll( ) throws URISyntaxException {
       List<Brand> brand=brandService.findAll();
       return ResponseEntity.created(new URI("/api/brands")).body(brand);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Brand>> findById(@Valid @PathVariable(name = "id") Long id) throws URISyntaxException {
        Optional<Brand> brand= brandService.findOne(id);
        return ResponseEntity.created(new URI("/api/brands/"+brand.get().getId())).body(brand);
    }

    @DeleteMapping("/{id}")
    public List<String> deleteById(@Valid @PathVariable(name = "id") Long id){
        brandService.delete(id);
        return List.of("Id has been deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateById(@Valid @PathVariable(name="id") Long id, @RequestBody Brand brand) throws URISyntaxException {
            brand=brandService.save(brand);
            return ResponseEntity.created(new URI("/api/brands/"+brand.getId())).body(brand);
    }
}
