package com.mayur.Job.Application.Portal.Service;

import com.mayur.Job.Application.Portal.Dtos.CompanyDto;
import com.mayur.Job.Application.Portal.Exception.CompanyNotFoundException;
import com.mayur.Job.Application.Portal.Mapper.CompanyMapper;
import com.mayur.Job.Application.Portal.Model.Company;
import com.mayur.Job.Application.Portal.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDto addCompany(CompanyDto companyDto) {
        Company company = CompanyMapper.toEntity(companyDto);
        Company savedCompany = companyRepository.save(company);
        return CompanyMapper.toDto(savedCompany);
    }

    public CompanyDto getCompanyById(Long companyId) throws CompanyNotFoundException{
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found"));
        return CompanyMapper.toDto(company);
    }
}
