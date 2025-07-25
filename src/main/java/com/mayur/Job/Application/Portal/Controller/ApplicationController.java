package com.mayur.Job.Application.Portal.Controller;

import com.mayur.Job.Application.Portal.Dtos.ApplicationDto;
import com.mayur.Job.Application.Portal.Service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/{applicantId}/{jobId}")
    public ResponseEntity<ApplicationDto> add(@PathVariable Long applicantId, @PathVariable Long jobId, @RequestBody ApplicationDto applicationDto) {
        return new ResponseEntity<>(applicationService.apply(applicantId, jobId, applicationDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAll() {
        return new ResponseEntity<>(applicationService.getAllApplications(), HttpStatus.OK);
    }

    @GetMapping("/{applicationId}")
    public ResponseEntity<ApplicationDto> getById(@PathVariable Long applicationId) {
        return new ResponseEntity<>(applicationService.getApplicationById(applicationId), HttpStatus.OK);
    }

    @DeleteMapping("/{applicationId}")
    public ResponseEntity<Void> delete(@PathVariable Long applicationId) {
        applicationService.deleteApplication(applicationId);
        return ResponseEntity.noContent().build();
    }
}
