package springboot.example.SpringBootCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.example.SpringBootCRUD.dao.EmployeeDAO;
import springboot.example.SpringBootCRUD.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO dao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO dao) {
		this.dao=dao;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Employee findOne(int id) {
		return dao.findOne(id);
	}

	@Override
	@Transactional
	public Employee updateEmployee(int id, Employee e) {
		return dao.updateEmployee(id, e);
	}

	@Override
	@Transactional
	public boolean deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

	@Override
	@Transactional
	public void addEmployee(Employee e) {
		dao.addEmployee(e);
	}

}
