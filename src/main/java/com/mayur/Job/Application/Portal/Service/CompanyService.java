package com.mayur.Job.Application.Portal.Service;

import com.mayur.Job.Application.Portal.Dtos.CompanyDto;
import com.mayur.Job.Application.Portal.Exception.CompanyNotFoundException;
import com.mayur.Job.Application.Portal.Mapper.CompanyMapper;
import com.mayur.Job.Application.Portal.Model.Company;
import com.mayur.Job.Application.Portal.Repository.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public CompanyDto getCompanyById(Long companyId) throws CompanyNotFoundException {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found"));
        return CompanyMapper.toDto(company);
    }

    public Page<CompanyDto> getCompanies(int page, int size, String direction, String sortBy) {
        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Company> allCompanies = companyRepository.findAll(pageable);
        return allCompanies.map(CompanyMapper::toDto);
    }

    @Transactional
    public CompanyDto updateCompany(Long companyId, CompanyDto companyDto) throws CompanyNotFoundException {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found"));
        if (companyDto.getName() != null) {
            company.setName(companyDto.getName());
        }
        if (companyDto.getIndustry() != null) {
            company.setIndustry(companyDto.getIndustry());
        }
        if (companyDto.getLocation() != null) {
            company.setLocation(companyDto.getLocation());
        }
        if (companyDto.getSize() != 0) {
            company.setSize(companyDto.getSize());
        }
        if (companyDto.getWebsite() != null) {
            company.setWebsite(companyDto.getWebsite());
        }
        if (companyDto.getDescription() != null) {
            company.setDescription(companyDto.getDescription());
        }
        if (companyDto.getFoundedYear() != 0) {
            company.setFoundedYear(companyDto.getFoundedYear());
        }
        return CompanyMapper.toDto(company);
    }

    public void deleteCompany(Long companyId) throws CompanyNotFoundException {
        if (!companyRepository.existsById(companyId)) {
            throw new CompanyNotFoundException("Company not found");
        }
        companyRepository.deleteById(companyId);
    }
}
