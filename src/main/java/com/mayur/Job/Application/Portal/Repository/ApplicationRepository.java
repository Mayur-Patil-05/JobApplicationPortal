package com.mayur.Job.Application.Portal.Repository;

import com.mayur.Job.Application.Portal.Model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}