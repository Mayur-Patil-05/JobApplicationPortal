package com.mayur.Job.Application.Portal.Controller;

import com.mayur.Job.Application.Portal.Exception.CompanyNotFoundException;
import com.mayur.Job.Application.Portal.Mapper.CompanyMapper;
import com.mayur.Job.Application.Portal.Model.Company;
import com.mayur.Job.Application.Portal.Service.CompanyService;
import com.mayur.Job.Application.Portal.Dtos.CompanyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<CompanyDto> add(@RequestBody CompanyDto companyDto){
        return new ResponseEntity<>(companyService.addCompany(companyDto), HttpStatus.CREATED);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long companyId) {
        return new ResponseEntity<>(companyService.getCompanyById(companyId), HttpStatus.OK);
    }
}
