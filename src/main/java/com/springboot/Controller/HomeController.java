package com.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.Employee;
import com.springboot.Service.EmployeeServiceImp;

@RestController
@RequestMapping("/api")
public class HomeController {

	private EmployeeServiceImp employeeServiceImp;
	public HomeController(EmployeeServiceImp employeeServiceImp) {
		super();
		this.employeeServiceImp = employeeServiceImp;
	}
	
	 //Insert Single Employee Data
	 @PostMapping("/employees")
	 public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){ 
		Employee addEmployee = employeeServiceImp.saveEmployee(employee); return new
		ResponseEntity<Employee>(addEmployee,HttpStatus.CREATED); 
	 }
	 
	//Insert Bulk Employee Data 
	@PostMapping("/employees/saveAll")
	public ResponseEntity<List<Employee>> saveAllEmployee(@RequestBody List<Employee> employee){
		List<Employee> saveEmployees = employeeServiceImp.saveAllEmployee(employee);
		return new ResponseEntity<List<Employee>>(saveEmployees, HttpStatus.CREATED);
	}

	//Retrieve All Employee Data
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list = employeeServiceImp.getAllEmployee();
		if(list != null) {
			return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Employee>>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	//Retrieve Employee Data By Id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
		Employee employee = employeeServiceImp.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee,HttpStatus.FOUND);
	}
	
	//Update Employee Details By Id
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
		employee.setId(id);
		Employee updateEmp = employeeServiceImp.updateEmployee(employee);
		return new ResponseEntity<Employee>(updateEmp,HttpStatus.OK);
	}
	
	//Delete Employee By Id
	@DeleteMapping("employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
		employeeServiceImp.deleteEmployee(id);
		return new ResponseEntity<Employee>(HttpStatus.OK);
	}
	
	//Retrieve Employee By Employee Name
	@GetMapping("employees/name/{name}")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable("name") String name){
	    List<Employee> employee = employeeServiceImp.getEmployeeByName(name);
	    return new ResponseEntity<List<Employee>>(employee,HttpStatus.FOUND);
	}
	
	//Retrieve Employee By City
	@GetMapping("employees/city")
	public ResponseEntity<List<Employee>> getEmployeeByCity(@RequestParam("city") String city){
		List<Employee> employee = employeeServiceImp.getEmployeeByCity(city);
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.FOUND);
	}
	//Retrieve Employee By Age
	@GetMapping("employees/age")
	public ResponseEntity<List<Employee>> getEmployeeByAge(@RequestParam("age") String age){
		List<Employee> employee = employeeServiceImp.getEmployeeByAge(age);
		return new ResponseEntity<List<Employee>>(employee,HttpStatus.FOUND);
	}
	//Retrieve n highest salary Employee 
	@GetMapping("employees/num")
	public ResponseEntity<Optional<Employee>> getEmployeeBySalary(@RequestParam("num") int num){
		Optional<Employee> employee = employeeServiceImp.getEmployeeBySalary(num);
		if(employee.isPresent()) {
			return new ResponseEntity<Optional<Employee>>(employee,HttpStatus.FOUND);	
		}
			return new ResponseEntity<Optional<Employee>>(employee,HttpStatus.NOT_FOUND);				
	}
}
