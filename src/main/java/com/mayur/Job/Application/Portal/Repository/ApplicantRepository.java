package com.mayur.Job.Application.Portal.Repository;

import com.mayur.Job.Application.Portal.Model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}