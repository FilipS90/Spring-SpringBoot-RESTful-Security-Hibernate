package springboot.example.SpringBootCRUD.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.example.SpringBootCRUD.entity.Employee;
import springboot.example.SpringBootCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee e){
		service.addEmployee(e);
		return e;
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee e, @PathVariable int id){
		service.updateEmployee(id,e);
		e.setId(id);
		return e;
	}
	
	@GetMapping("/employees/{id}")
	public Employee findById(@PathVariable int id) {
		return service.findOne(id);
	}
	
	@DeleteMapping("/employees/{id}")
	public void delete(@PathVariable int id) {
		service.deleteEmployee(id);
	}
	
}
