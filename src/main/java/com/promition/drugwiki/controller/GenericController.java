package com.promition.drugwiki.controller;

import com.promition.drugwiki.entity.Brand;
import com.promition.drugwiki.entity.Generic;
import com.promition.drugwiki.service.GenericService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generics")
public class GenericController {
    @Autowired
    private GenericService genericService;

    @PostMapping
    public ResponseEntity<Generic> create(@Valid @RequestBody Generic generic) throws URISyntaxException {
         generic=genericService.save(generic);

         return ResponseEntity.created(new URI("/api/generics/"+generic.getId())).body(generic);
    }

    @GetMapping
    public ResponseEntity<List<Generic>> getAll() throws URISyntaxException {
        List<Generic> generic=genericService.findAll();
        return ResponseEntity.created(new URI("/api/generics")).body(generic);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Generic>> findById(@Valid @PathVariable(name="id") Long id) throws URISyntaxException {
        Optional<Generic> generic=genericService.findOne(id);
        return ResponseEntity.created(new URI("/api/generics/"+generic.get().getId())).body(generic);
    }

    @DeleteMapping("/{id}")
    public List<String> deleteById(@Valid @PathVariable(name = "id") Long id){
        genericService.delete(id);
        return List.of("Id has been deleted");
    }

    @PutMapping("/{id}")
    public Generic update(@PathVariable Long id, @RequestBody Generic generic){
        generic=genericService.update(id,generic);
        return generic;
    }
}
