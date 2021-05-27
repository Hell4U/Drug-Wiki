package com.promition.drugwiki.service;

import com.promition.drugwiki.entity.Brand;
import com.promition.drugwiki.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand save(Brand brand){
         return brandRepository.save(brand);
    }

    public Brand update(Long id, Brand brand){
        Brand existingBrand=brandRepository.getOne(id);
        if(brand.getPackageUnit()!=0)
            existingBrand.setPackageUnit(brand.getPackageUnit());
        if(brand.getPricePerUnit()!=0)
            existingBrand.setPricePerUnit(brand.getPricePerUnit());

        existingBrand.getGenerics().clear();
        existingBrand.getGenerics().addAll(brand.getGenerics());
        brand=brandRepository.save(existingBrand);
        return brand;
    }

    public List<Brand> findContainingName(String name){
        return brandRepository.findByNameContaining(name);
    }

    @Transactional(readOnly = true)
    public Optional<Brand> findOne(Long id) {
        return brandRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public void delete(Long id) {
        brandRepository.deleteById(id);
    }
}
