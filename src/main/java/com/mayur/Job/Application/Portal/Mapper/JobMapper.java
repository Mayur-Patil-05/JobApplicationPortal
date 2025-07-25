package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.JobDto;
import com.mayur.Job.Application.Portal.Model.Job;

import java.time.LocalDate;
import java.util.List;

public class JobMapper {
    public static JobDto toDto(Job job) {
        if (job == null) return null;

        return new JobDto(
                job.getJobId(),
                job.getTitle(),
                job.getDescription(),
                job.getRequirements(),
                job.getLocation(),
                job.getEmploymentType(),
                job.getSalaryRange(),
                job.getDatePosted(),
                job.getDeadline(),
                job.getExperienceLevel(),
                job.getCompany() != null ? CompanyMapper.toDto(job.getCompany()) : null,
                job.getApplications() != null
                        ? job.getApplications().stream()
                        .map(ApplicationMapper::toShallowDto)
                        .toList()
                        : List.of()
        );
    }

    public static JobDto toShallowDto(Job job) {
        if (job == null) return null;

        return new JobDto(
                job.getJobId(),
                job.getTitle(),
                job.getDescription(),
                job.getRequirements(),
                job.getLocation(),
                job.getEmploymentType(),
                job.getSalaryRange(),
                job.getDatePosted(),
                job.getDeadline(),
                job.getExperienceLevel(),
                null,
                null
        );
    }

    public static Job toEntity(JobDto jobDto) {
        if (jobDto == null) return null;

        Job job = new Job();
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        job.setRequirements(jobDto.getRequirements());
        job.setLocation(jobDto.getLocation());
        job.setEmploymentType(jobDto.getEmploymentType());
        job.setSalaryRange(jobDto.getSalaryRange());
        job.setDatePosted(LocalDate.now());
        job.setDeadline(jobDto.getDeadline());
        job.setExperienceLevel(jobDto.getExperienceLevel());
        return job;
    }
}
