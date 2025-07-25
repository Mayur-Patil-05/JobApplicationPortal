package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.CompanyDto;
import com.mayur.Job.Application.Portal.Model.Company;

public class CompanyMapper {

    public static CompanyDto toDto(Company company) {
        if (company == null) return null;

        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(company.getCompanyId());
        companyDto.setName(company.getName());
        companyDto.setIndustry(company.getIndustry());
        companyDto.setLocation(company.getLocation());
        companyDto.setSize(company.getSize());
        companyDto.setWebsite(company.getWebsite());
        companyDto.setDescription(company.getDescription());
        companyDto.setFoundedYear(company.getFoundedYear());
        return companyDto;
    }

    public static Company toEntity(CompanyDto companyDto) {
        if (companyDto == null) return null;

        Company company = new Company();
        company.setName(companyDto.getName());
        company.setIndustry(companyDto.getIndustry());
        company.setLocation(companyDto.getLocation());
        company.setSize(companyDto.getSize());
        company.setWebsite(companyDto.getWebsite());
        company.setDescription(companyDto.getDescription());
        company.setFoundedYear(companyDto.getFoundedYear());
        return company;
    }
}
