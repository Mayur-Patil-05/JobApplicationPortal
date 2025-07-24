package com.mayur.Job.Application.Portal.Controller;

import com.mayur.Job.Application.Portal.Dtos.ApplicantDto;
import com.mayur.Job.Application.Portal.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<ApplicantDto> add(@RequestBody ApplicantDto applicantDto){
        return new ResponseEntity<>(applicantService.addApplicant(applicantDto), HttpStatus.CREATED);
    }

    @GetMapping("/{applicantId}")
    public ResponseEntity<ApplicantDto> getById(@PathVariable Long applicantId){
        return new ResponseEntity<>(applicantService.getApplicantByID(applicantId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ApplicantDto>> getAll(){
        return new ResponseEntity<>(applicantService.getAllApplicant(), HttpStatus.OK);
    }

    @PutMapping("/{applicantId}")
    public ResponseEntity<ApplicantDto> update(@PathVariable Long applicantId, @RequestBody ApplicantDto applicantDto){
        return new ResponseEntity<>(applicantService.updateApplicant(applicantId,applicantDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{applicantId}")
    public ResponseEntity<Void> delete(@PathVariable Long applicantId){
        applicantService.deleteApplicant(applicantId);
        return ResponseEntity.noContent().build();
    }
}
