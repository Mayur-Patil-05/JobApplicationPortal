package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.ApplicantDto;
import com.mayur.Job.Application.Portal.Dtos.ApplicationDto;
import com.mayur.Job.Application.Portal.Dtos.JobDto;
import com.mayur.Job.Application.Portal.Model.Application;
import com.mayur.Job.Application.Portal.Model.Job;

import java.time.LocalDateTime;

public class ApplicationMapper {
    public static ApplicationDto toDto(Application application) {
        return new ApplicationDto(
                application.getApplicationId(),
                application.getAppliedAt(),
                application.getCoverLetter(),
                application.getResumeUrl(),
                JobMapper.toDto(application.getJob()),
                ApplicantMapper.toDto(application.getApplicant())
        );
    }

    public static Application toEntity(ApplicationDto applicationDto) {
        Application application = new Application();
        application.setAppliedAt(LocalDateTime.now());
        application.setCoverLetter(applicationDto.getCoverLetter());
        application.setResumeUrl(applicationDto.getResumeUrl());
        return application;
    }
}
