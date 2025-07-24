package com.mayur.Job.Application.Portal.Service;

import com.mayur.Job.Application.Portal.Dtos.JobDto;
import com.mayur.Job.Application.Portal.Exception.CompanyNotFoundException;
import com.mayur.Job.Application.Portal.Exception.JobNotFoundException;
import com.mayur.Job.Application.Portal.Mapper.JobMapper;
import com.mayur.Job.Application.Portal.Model.Company;
import com.mayur.Job.Application.Portal.Model.Job;
import com.mayur.Job.Application.Portal.Repository.CompanyRepository;
import com.mayur.Job.Application.Portal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public JobService(JobRepository jobRepository, CompanyRepository companyRepository) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
    }

    public JobDto postJob(Long companyId, JobDto jobDto) throws CompanyNotFoundException {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new CompanyNotFoundException("Company not found"));
        Job job = JobMapper.toEntity(jobDto);

        job.setCompany(company);
        Job savedJob = jobRepository.save(job);
        return JobMapper.toDto(savedJob);
    }

    public JobDto getJobById(Long jobId) throws JobNotFoundException {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job not found"));
        return JobMapper.toDto(job);
    }
}
