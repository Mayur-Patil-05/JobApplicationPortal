package com.mayur.Job.Application.Portal.Mapper;

import com.mayur.Job.Application.Portal.Dtos.ApplicationDto;
import com.mayur.Job.Application.Portal.Dtos.JobDto;
import com.mayur.Job.Application.Portal.Enum.JobType;
import com.mayur.Job.Application.Portal.Model.Job;

import java.time.LocalDate;
import java.util.List;

public class JobMapper {

    public static JobDto toDto(Job job) {
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
                job.getApplications() != null ?
                        job.getApplications().stream().map(ApplicationMapper::toDto).toList() :
                        List.of()
        );
    }

    public static Job job(JobDto jobDto) {
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
