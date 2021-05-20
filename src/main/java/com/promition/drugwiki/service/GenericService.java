package com.promition.drugwiki.service;

import com.promition.drugwiki.entity.Generic;
import com.promition.drugwiki.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenericService {

    @Autowired
    private GenericRepository genericRepository;

    public Generic save(@Valid Generic generic){
        return genericRepository.save(generic);
    }

    @Transactional(readOnly = true)
    public Optional<Generic> findOne(Long id){
        return genericRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<Generic> findAll(Pageable pageable){
        return genericRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Generic> findAll(){
        return genericRepository.findAll();
    }

    public void delete(Long id){
        genericRepository.deleteById(id);
    }
}
