package com.aash.SecondSpring.company;

import java.util.List;

public interface CompanyService {
    public List<Company> findAll();

    Company findCompanyById(Long id);

    void listCompany(Company company);

    boolean deleteCompany(Long id);

    boolean updateCompany(Long id, Company params);
}
