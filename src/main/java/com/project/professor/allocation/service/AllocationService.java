package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class AllocationService {

	private final AllocationRepository repository;
	private final ProfessorService professorService;
	private final CourseService courseService;

	public AllocationService(AllocationRepository repository, ProfessorService professorService,
			CourseService courseService) {
		super();
		this.repository = repository;
		this.professorService = professorService;
		this.courseService = courseService;
	}

	public List<Allocation> findAll() {

		List<Allocation> allocations = repository.findAll();
		return allocations;
	}

	public Allocation findById(Long id) {
		Allocation allocation = repository.findById(id).orElse(null);
		return allocation;

	}

	public Allocation create(Allocation allocation) {
		allocation.setId(null);
		Allocation newAllocation = save (allocation);
		return newAllocation;

	}

	public Allocation update(Allocation allocation) {

		if (repository.existsById(allocation.getId())) {
			Allocation newAllocation = save(allocation);
			return newAllocation;
		}
		return null;

	}

	private Allocation save(Allocation allocation) {
		Allocation newAllocation1 = repository.save(allocation);
		Professor professor = professorService.findById(newAllocation1.getProfessorId());
		Course course = courseService.findById(newAllocation1.getCourseId());
		newAllocation1.setProfessor(professor);
		newAllocation1.setCourse(course);
		return newAllocation1;
	}

	public void deleteById(Long id) {

			if (repository.existsById(id)) {
				repository.deleteById(id);
			}
	 }
}
