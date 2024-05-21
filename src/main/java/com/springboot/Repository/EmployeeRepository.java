package com.springboot.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findEmployeeById(int id);
	List<Employee> findEmployeeByName(String name);
	List<Employee> findEmployeeByCity(String city);
	List<Employee> findByAgeGreaterThanEqual(String age);
	
	@Query("SELECT e FROM Employee e")
	List<Employee> findAllEmployees();
	
}
