package com.niit.NIITPROJECT.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niit.NIITPROJECT.model.Emp;

public interface EmployeeRepository extends JpaRepository<Emp
, Long> {

}
