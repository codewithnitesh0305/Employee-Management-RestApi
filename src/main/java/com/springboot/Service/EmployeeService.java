package com.springboot.Service;

import java.util.List;
import java.util.Optional;

import com.springboot.Entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> saveAllEmployee(List<Employee> employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(int id);
	
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getEmployeeByCity(String city);
	public List<Employee> getEmployeeByAge(String age);
	public Optional<Employee> getEmployeeBySalary(int num);
	
}
