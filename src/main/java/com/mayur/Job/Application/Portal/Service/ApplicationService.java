package com.mayur.Job.Application.Portal.Service;

import com.mayur.Job.Application.Portal.Dtos.ApplicationDto;
import com.mayur.Job.Application.Portal.Exception.ApplicantNotFoundException;
import com.mayur.Job.Application.Portal.Exception.ApplicationNotFoundException;
import com.mayur.Job.Application.Portal.Exception.JobNotFoundException;
import com.mayur.Job.Application.Portal.Mapper.ApplicationMapper;
import com.mayur.Job.Application.Portal.Model.Applicant;
import com.mayur.Job.Application.Portal.Model.Application;
import com.mayur.Job.Application.Portal.Model.Job;
import com.mayur.Job.Application.Portal.Repository.ApplicantRepository;
import com.mayur.Job.Application.Portal.Repository.ApplicationRepository;
import com.mayur.Job.Application.Portal.Repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicantRepository applicantRepository;
    private final JobRepository jobRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository, ApplicantRepository applicantRepository, JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.applicantRepository = applicantRepository;
        this.jobRepository = jobRepository;
    }

    @Transactional
    public ApplicationDto apply(Long applicantId, Long jobId, ApplicationDto applicationDto) throws ApplicantNotFoundException, JobNotFoundException {
        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new ApplicantNotFoundException("Applicant not found"));
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new JobNotFoundException("Job not found"));

        Application application = ApplicationMapper.toEntity(applicationDto);
        application.setApplicant(applicant);
        application.setJob(job);
        Application savedApplication = applicationRepository.save(application);
        return ApplicationMapper.toDto(savedApplication);
    }

    public List<ApplicationDto> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream().map(ApplicationMapper::toDto).toList();
    }

    public ApplicationDto getApplicationById(Long applicationId) throws ApplicationNotFoundException {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found"));
        return ApplicationMapper.toDto(application);
    }

    public void deleteApplication(Long applicationId) throws ApplicationNotFoundException {
        if (!applicationRepository.existsById(applicationId)) {
            throw new ApplicationNotFoundException("Application not found");
        }
        applicationRepository.deleteById(applicationId);
    }
}
