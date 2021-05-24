package com.promition.drugwiki.controller;

import com.promition.drugwiki.entity.Generic;
import com.promition.drugwiki.entity.Ingredient;
import com.promition.drugwiki.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<Ingredient> create(@Valid @RequestBody Ingredient ingredient) throws URISyntaxException {
        ingredient= ingredientService.save(ingredient);
        return ResponseEntity.created(new URI("/api/ingredients/"+ingredient.getId())).body(ingredient);
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAll() throws URISyntaxException {
        List<Ingredient> ingredient=ingredientService.findAll();
        return ResponseEntity.created(new URI("/api/generics")).body(ingredient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Ingredient>> findById(@Valid @PathVariable(name="id") Long id) throws URISyntaxException {
        Optional<Ingredient> ingredient=ingredientService.findOne(id);
        return ResponseEntity.created(new URI("/api/generics/"+ingredient.get().getId())).body(ingredient);
    }

    @DeleteMapping("/{id}")
    public List<String> deleteById(@Valid @PathVariable(name = "id") Long id){
        ingredientService.delete(id);
        return List.of("Id has been deleted");
    }

    @PutMapping("/{id}")
    public Ingredient getOne( @PathVariable(name = "id") Long id, @RequestBody Ingredient ingredient){
        ingredient=ingredientService.update(id,ingredient);
        return ingredient;
    }
}
