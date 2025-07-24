package com.mayur.Job.Application.Portal.Dtos;

import com.mayur.Job.Application.Portal.Enum.JobType;
import com.mayur.Job.Application.Portal.Model.Application;
import com.mayur.Job.Application.Portal.Model.Company;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobDto {
    private Long jobId;
    private String title;
    private String description;
    private String requirements;
    private String location;
    private JobType employmentType;
    private String salaryRange;
    private LocalDate datePosted;
    private LocalDate deadline;
    private String experienceLevel;
    private List<ApplicationDto> applications;

    public JobDto() {
    }

    public JobDto(Long jobId, String title, String description, String requirements, String location, JobType employmentType, String salaryRange, LocalDate datePosted, LocalDate deadline, String experienceLevel, List<ApplicationDto> applications) {
        this.jobId = jobId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.location = location;
        this.employmentType = employmentType;
        this.salaryRange = salaryRange;
        this.datePosted = datePosted;
        this.deadline = deadline;
        this.experienceLevel = experienceLevel;
        this.applications = applications;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public JobType getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(JobType employmentType) {
        this.employmentType = employmentType;
    }

    public String getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(String salaryRange) {
        this.salaryRange = salaryRange;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public List<ApplicationDto> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationDto> applications) {
        this.applications = applications;
    }
}
