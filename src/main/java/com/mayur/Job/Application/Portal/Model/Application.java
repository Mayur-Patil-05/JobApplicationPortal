package com.mayur.Job.Application.Portal.Model;

import com.mayur.Job.Application.Portal.Enum.JobType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;
    private String title;
    private String description;
    private String requirements;
    private String location;
    private JobType employmentType;
    private String salaryRange;
    private LocalDate datePosted;
    private LocalDate deadline;
    private String experienceLevel;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    public Application() {
    }

    public Application(Long applicationId, String title, String description, String requirements, String location, JobType employmentType, String salaryRange, LocalDate datePosted, LocalDate deadline, String experienceLevel, Job job, Applicant applicant) {
        this.applicationId = applicationId;
        this.title = title;
        this.description = description;
        this.requirements = requirements;
        this.location = location;
        this.employmentType = employmentType;
        this.salaryRange = salaryRange;
        this.datePosted = datePosted;
        this.deadline = deadline;
        this.experienceLevel = experienceLevel;
        this.job = job;
        this.applicant = applicant;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
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

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
