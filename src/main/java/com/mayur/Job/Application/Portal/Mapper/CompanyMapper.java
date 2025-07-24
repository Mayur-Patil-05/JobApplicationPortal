package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.CompanyDto;
import com.mayur.Job.Application.Portal.Dtos.JobDto;
import com.mayur.Job.Application.Portal.Model.Company;

import java.util.List;

public class CompanyMapper {
    public static CompanyDto toDto(Company company) {
        return new CompanyDto(
                company.getCompanyId(),
                company.getName(),
                company.getIndustry(),
                company.getLocation(),
                company.getSize(),
                company.getWebsite(),
                company.getDescription(),
                company.getFoundedYear(),
                company.getJobs() != null ?
                        company.getJobs().stream().map(JobMapper::toDto).toList() :
                        List.of());
    }

    public static Company toEntity(CompanyDto companyDto) {
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
