package com.mayur.Job.Application.Portal.Dtos;

import com.mayur.Job.Application.Portal.Model.Job;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {
    private Long companyId;
    private String name;
    private String industry;
    private String location;
    private int size;
    private String website;
    private String description;
    private int foundedYear;
    private List<JobDto> jobs;

    public CompanyDto() {
    }

    public CompanyDto(Long companyId, String name, String industry, String location, int size, String website, String description, int foundedYear, List<JobDto> jobs) {
        this.companyId = companyId;
        this.name = name;
        this.industry = industry;
        this.location = location;
        this.size = size;
        this.website = website;
        this.description = description;
        this.foundedYear = foundedYear;
        this.jobs = jobs;
    }

    public CompanyDto(Long companyId, String name, String industry, String location, String location1, int size, String website, String description, int foundedYear, List<Object> list) {
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public List<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobDto> jobs) {
        this.jobs = jobs;
    }
}
