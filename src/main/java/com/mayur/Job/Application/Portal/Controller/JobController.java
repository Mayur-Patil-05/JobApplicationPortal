package com.mayur.Job.Application.Portal.Controller;

import com.mayur.Job.Application.Portal.Dtos.JobDto;
import com.mayur.Job.Application.Portal.Exception.JobNotFoundException;
import com.mayur.Job.Application.Portal.Mapper.JobMapper;
import com.mayur.Job.Application.Portal.Model.Job;
import com.mayur.Job.Application.Portal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<JobDto> addJob(@PathVariable Long companyId, @RequestBody JobDto jobDto) {
        return new ResponseEntity<>(jobService.postJob(companyId, jobDto), HttpStatus.CREATED);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long jobId) {
        return new ResponseEntity<>(jobService.getJobById(jobId), HttpStatus.OK);
    }
}
