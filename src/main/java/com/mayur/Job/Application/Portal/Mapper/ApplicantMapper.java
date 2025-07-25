package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.ApplicantDto;
import com.mayur.Job.Application.Portal.Model.Applicant;

import java.util.List;

public class ApplicantMapper {
    public static ApplicantDto toDto(Applicant applicant) {
        if (applicant == null) return null;

        return new ApplicantDto(
                applicant.getApplicantId(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getEmail(),
                applicant.getPhoneNumber(),
                applicant.getResumeUrl(),
                applicant.getLinkedinProfile(),
                applicant.getSkills(),
                applicant.getEducation(),
                applicant.getExperience(),
                applicant.getPortfolioUrl(),
                applicant.getApplications() != null
                        ? applicant.getApplications().stream()
                        .map(ApplicationMapper::toShallowDto)
                        .toList()
                        : List.of()
        );
    }

    public static ApplicantDto toShallowDto(Applicant applicant) {
        if (applicant == null) return null;

        return new ApplicantDto(
                applicant.getApplicantId(),
                applicant.getFirstName(),
                applicant.getLastName(),
                applicant.getEmail(),
                applicant.getPhoneNumber(),
                applicant.getResumeUrl(),
                applicant.getLinkedinProfile(),
                applicant.getSkills(),
                applicant.getEducation(),
                applicant.getExperience(),
                applicant.getPortfolioUrl(),
                null
        );
    }

    public static Applicant toEntity(ApplicantDto applicantDto) {
        if (applicantDto == null) return null;

        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantDto.getFirstName());
        applicant.setLastName(applicantDto.getLastName());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setPhoneNumber(applicantDto.getPhoneNumber());
        applicant.setResumeUrl(applicantDto.getResumeUrl());
        applicant.setLinkedinProfile(applicantDto.getLinkedinProfile());
        applicant.setSkills(applicantDto.getSkills());
        applicant.setEducation(applicantDto.getEducation());
        applicant.setExperience(applicantDto.getExperience());
        applicant.setPortfolioUrl(applicantDto.getPortfolioUrl());
        return applicant;
    }
}
