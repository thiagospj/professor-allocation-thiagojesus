package com.project.professor.allocation.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {

	@Autowired
	DepartmentRepository repository;

	@Test
	public void findById() {
		Department search = repository.findById(5L).orElse(null);
		System.out.println(search);

	}

	@Test
	public void create() {
		Department biology = new Department(null, "History");
		Department biology2 = repository.save(biology);
		System.out.println(biology2);
	}

	@Test
	public void update() {
		Department biology = new Department(5L, "mamute");
		Department biology2 = repository.save(biology);
		System.out.println(biology2);

	}

	@Test
	public void deleteById() {

		if (repository.existsById(1L)) {
			repository.deleteById(1L);
		}
	}

	@Test
	public void findingByname() {
		repository.findByNameContainingIgnoreCase(null);
	}
}
