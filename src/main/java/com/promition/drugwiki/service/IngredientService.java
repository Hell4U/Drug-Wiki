package com.promition.drugwiki.service;

import com.promition.drugwiki.entity.Ingredient;
import com.promition.drugwiki.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    @Transactional(readOnly = true)
    public Optional<Ingredient> findOne(Long id){
        return ingredientRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<Ingredient> findAll(Pageable pageable){
        return ingredientRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Ingredient> findAll(){
        return ingredientRepository.findAll();
    }

    public void delete(Long id){
        ingredientRepository.deleteById(id);
    }
}
