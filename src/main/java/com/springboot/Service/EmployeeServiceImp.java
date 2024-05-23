package com.springboot.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.CustomeException.BusinessException;
import com.springboot.Entity.Employee;
import com.springboot.Exception.EmployeeNotFountException;
import com.springboot.Repository.EmployeeRepository;
@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
			if(employee.getName().isEmpty() || employee.getName().length() == 0 || employee.getAge().isEmpty() || employee.getAge().length() == 0 ||  employee.getCity().length() == 0 || employee.getCity().isEmpty() ) {
				throw new BusinessException("601", "Input field is empty");
			}
		try {
			Employee saveEmployee = employeeRepository.save(employee);
			return saveEmployee;
		}catch(IllegalArgumentException e) {
			throw new BusinessException("602"," Given employee is null, please "+e.getMessage());
		}catch(Exception e) {
			throw new BusinessException("603", "Something went wrong.. "+ e.getMessage());
		}
		
	}
	@Override
	public List<Employee> saveAllEmployee(List<Employee> employee) {
		// TODO Auto-generated method stub
		return employeeRepository.saveAll(employee);
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> empList = null;
		try {
			empList = employeeRepository.findAll();			
		}catch(Exception e) {
			throw new BusinessException("605","Something went wrong "+e.getMessage());
		}
		if(empList.isEmpty()) {
			throw new BusinessException("604", "List is empty");
		}
		return empList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		try {
			Employee employee = employeeRepository.findEmployeeById(id).get();
			return employee;
		}catch(IllegalArgumentException e) {
			throw new BusinessException("606", "Given employee id is null, please send some id "+e.getMessage());
		}catch(NoSuchElementException e) {
			throw new BusinessException("607", "Given employee Id is not exist "+e.getMessage());
		}
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}
	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		try {
			employeeRepository.deleteById(id);
		}catch(IllegalArgumentException e) {
			throw new BusinessException("608", "Given employee is null "+e.getMessage());
		}
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
