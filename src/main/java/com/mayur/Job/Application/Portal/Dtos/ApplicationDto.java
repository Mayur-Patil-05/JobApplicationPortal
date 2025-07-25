package com.mayur.Job.Application.Portal.Dtos;

import java.time.LocalDateTime;

public class ApplicationDto {
    private Long applicationId;
    private LocalDateTime appliedAt;
    private String coverLetter;
    private String resumeUrl;
    private JobDto job;
    private ApplicantDto applicant;

    public ApplicationDto() {
    }

    public ApplicationDto(Long applicationId, LocalDateTime appliedAt, String coverLetter, String resumeUrl, JobDto job, ApplicantDto applicant) {
        this.applicationId = applicationId;
        this.appliedAt = appliedAt;
        this.coverLetter = coverLetter;
        this.resumeUrl = resumeUrl;
        this.job = job;
        this.applicant = applicant;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    public ApplicantDto getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantDto applicant) {
        this.applicant = applicant;
    }
}
