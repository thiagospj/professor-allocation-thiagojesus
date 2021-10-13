package com.project.professor.allocation.service;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	public final DepartmentRepository repository;

	public DepartmentService(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}
	

}
