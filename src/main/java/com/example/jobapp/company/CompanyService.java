package com.example.jobapp.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void addCompany(Company company);
    Company getCompanyById(Long id);
    void updateCompany(Long id, Company company);
    void deleteCompany(Long id);
}
