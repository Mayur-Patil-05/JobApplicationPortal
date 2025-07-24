package com.mayur.Job.Application.Portal.Dtos;

import com.mayur.Job.Application.Portal.Model.Application;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class ApplicantDto {
    private Long applicantId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String resumeUrl;
    private String linkedinProfile;
    private List<String> skills;
    private String education;
    private String experience;
    private String portfolioUrl;
    private List<ApplicationDto> applications;

    public ApplicantDto() {
    }

    public ApplicantDto(Long applicantId, String firstName, String lastName, String email, String phoneNumber, String resumeUrl, String linkedinProfile, List<String> skills, String education, String experience, String portfolioUrl, List<ApplicationDto> applications) {
        this.applicantId = applicantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.resumeUrl = resumeUrl;
        this.linkedinProfile = linkedinProfile;
        this.skills = skills;
        this.education = education;
        this.experience = experience;
        this.portfolioUrl = portfolioUrl;
        this.applications = applications;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getLinkedinProfile() {
        return linkedinProfile;
    }

    public void setLinkedinProfile(String linkedinProfile) {
        this.linkedinProfile = linkedinProfile;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getPortfolioUrl() {
        return portfolioUrl;
    }

    public void setPortfolioUrl(String portfolioUrl) {
        this.portfolioUrl = portfolioUrl;
    }

    public List<ApplicationDto> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationDto> applications) {
        this.applications = applications;
    }
}
