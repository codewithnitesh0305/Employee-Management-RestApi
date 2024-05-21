package com.springboot.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Entity.Employee;
import com.springboot.Exception.EmployeeNotFountException;
import com.springboot.Repository.EmployeeRepository;
@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public List<Employee> saveAllEmployee(List<Employee> employee) {
		// TODO Auto-generated method stub
		return employeeRepository.saveAll(employee);
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(() -> new EmployeeNotFountException("Employee with id "+id+ "not found"));
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFountException("Employee with id "+id+"Not Found"));
		 employeeRepository.delete(employee);
	}
	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		List<Employee> employee = employeeRepository.findEmployeeByName(name);
		if(employee == null || employee.isEmpty()) {
			throw new EmployeeNotFountException("Employee with name "+name+" Not Found");
		}
		return employee;
	}
	@Override
	public List<Employee> getEmployeeByCity(String city) {
		// TODO Auto-generated method stub
		List<Employee> employee = employeeRepository.findEmployeeByCity(city);
		if(employee == null || employee.isEmpty()) {
			throw new EmployeeNotFountException("Employee with city"+city+" Not Found");
		}
		return employee;
	}
	@Override
	public List<Employee> getEmployeeByAge(String age) {
		// TODO Auto-generated method stub
		List<Employee> employee = employeeRepository.findByAgeGreaterThanEqual(age);
		if(employee == null || employee.isEmpty()) {
			throw new EmployeeNotFountException("Employee with age"+age+"Not Found");
		}
		return employee;
	}
	@Override
	public Optional<Employee> getEmployeeBySalary(int num) {
		// TODO Auto-generated method stub
		 num = num - 1;
		 List<Employee> employee = employeeRepository.findAllEmployees();
		 Employee emp = employee.stream().sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary())).skip(num).findFirst().get();
		 
		return Optional.ofNullable(emp);
	}

	

}
