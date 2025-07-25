package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.ApplicationDto;
import com.mayur.Job.Application.Portal.Model.Application;

import java.time.LocalDateTime;

public class ApplicationMapper {


    public static ApplicationDto toDto(Application application) {
        if (application == null) return null;

        return new ApplicationDto(
                application.getApplicationId(),
                application.getAppliedAt(),
                application.getCoverLetter(),
                application.getResumeUrl(),
                JobMapper.toShallowDto(application.getJob()),
                ApplicantMapper.toShallowDto(application.getApplicant())
        );
    }

    public static ApplicationDto toShallowDto(Application application) {
        if (application == null) return null;

        return new ApplicationDto(
                application.getApplicationId(),
                application.getAppliedAt(),
                application.getCoverLetter(),
                application.getResumeUrl(),
                null,
                null
        );
    }

    public static Application toEntity(ApplicationDto applicationDto) {
        if (applicationDto == null) return null;

        Application application = new Application();
        application.setAppliedAt(LocalDateTime.now());
        application.setCoverLetter(applicationDto.getCoverLetter());
        application.setResumeUrl(applicationDto.getResumeUrl());
        return application;
    }
}
