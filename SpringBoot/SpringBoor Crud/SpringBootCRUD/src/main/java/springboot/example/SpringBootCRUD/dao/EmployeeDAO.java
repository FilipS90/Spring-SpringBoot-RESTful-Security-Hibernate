package springboot.example.SpringBootCRUD.dao;

import java.util.List;

import springboot.example.SpringBootCRUD.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findOne(int id);
	
	public Employee updateEmployee(int id, Employee e);
	
	public boolean deleteEmployee(int id);

	void addEmployee(Employee e);
	
	
	
}
