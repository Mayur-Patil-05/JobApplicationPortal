package com.mayur.Job.Application.Portal.Repository;

import com.mayur.Job.Application.Portal.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}