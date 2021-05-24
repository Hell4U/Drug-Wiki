package com.promition.drugwiki.service;

import com.promition.drugwiki.entity.Company;
import com.promition.drugwiki.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company update(Long id, Company company){
        Company existing=companyRepository.getOne(id);
        if(company.getAddress()!=null)
            existing.setAddress(company.getAddress());
        if(company.getPhone()!=null)
            existing.setPhone(company.getPhone());
        if(company.getEmail()!=null)
            existing.setEmail(company.getEmail());
        if(company.getFax()!=null)
            existing.setFax(company.getFax());
        if(company.getWebsite()!=null)
            existing.setWebsite(company.getWebsite());
        company=companyRepository.save(existing);
        return company;
    }

    @Transactional(readOnly = true)
    public Optional<Company> findOne(Long id) {
        return companyRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Page<Company> findAll(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
