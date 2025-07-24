package com.mayur.Job.Application.Portal.Repository;

import com.mayur.Job.Application.Portal.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}