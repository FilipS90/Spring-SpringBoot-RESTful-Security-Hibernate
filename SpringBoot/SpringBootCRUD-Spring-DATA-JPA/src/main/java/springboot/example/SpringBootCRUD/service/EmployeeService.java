package springboot.example.SpringBootCRUD.service;

import java.util.List;

import springboot.example.SpringBootCRUD.entity.Employee;

public interface EmployeeService {
		
	public List<Employee> findAll();
	
	public Employee findOne(int id);
	
	public Employee updateEmployee(Employee e);
	
	public boolean deleteEmployee(int id);

	void addEmployee(Employee e);
}
