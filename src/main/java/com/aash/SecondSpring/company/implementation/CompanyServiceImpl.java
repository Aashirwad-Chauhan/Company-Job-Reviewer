package com.aash.SecondSpring.company.implementation;

import com.aash.SecondSpring.company.Company;
import com.aash.SecondSpring.company.CompanyDB;
import com.aash.SecondSpring.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDB repo;

    public CompanyServiceImpl(CompanyDB repo) {
        this.repo = repo;
    }

    @Override
    public List<Company> findAll() {
        return repo.findAll();
    }

    @Override
    public Company findCompanyById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void listCompany(Company company) {
        repo.save(company);
    }

    @Override
    public boolean deleteCompany(Long id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(Long id, Company params) {
        Optional<Company> optionalCompany = repo.findById(id);

        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setName(params.getName());
            company.setAddress(params.getAddress());
            company.setDesc(params.getDesc());
            company.setJobs(params.getJobs());

            repo.save(company);
            return true;
        }
        else return false;
    }

}
