package com.mayur.Job.Application.Portal.Model;

import com.mayur.Job.Application.Portal.Enum.JobType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    private String title;
    private String description;
    private String requirements;
    private String location;
    @Enumerated(EnumType.STRING)
    private JobType employmentType;
    private String salaryRange;
    private LocalDate datePosted;
    private LocalDate deadline;
    private String experienceLevel;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "job")
    private List<Application> applications = new ArrayList<>();

    public Job() {
    }

    public Job(Long jobId, String title, String description, String requirements, String location, JobType employmentType, String salaryRange, LocalDate datePosted, LocalDate deadline, String experienceLevel, Company company, List<Application> applications) {
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
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
