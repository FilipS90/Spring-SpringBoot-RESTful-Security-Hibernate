package springboot.example.SpringBootCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.example.SpringBootCRUD.dao.EmployeeRepository;
import springboot.example.SpringBootCRUD.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository repo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repo) {
		this.repo=repo;
	}
	
	
	//Spring JPA out of the box @Transactional
	@Override
	public List<Employee> findAll() {
		return repo.findAll();
	}
	
	//Spring JPA out of the box @Transactional
	@Override
	public Employee findOne(int id) {
		Optional<Employee> x = repo.findById(id);
		Employee q = x.get();
		
		if(q==null)
			throw new RuntimeException("No such Employee.");
		
		return q;
	}
	
	//Spring JPA out of the box @Transactional
	@Override
	public Employee updateEmployee(Employee e) {
		return repo.save(e);
	}
	
	//Spring JPA out of the box @Transactional
	@Override
	public boolean deleteEmployee(int id) {
		repo.deleteById(id);
		return true;
	}
	
	//Spring JPA out of the box @Transactional
	@Override
	public void addEmployee(Employee e) {
		repo.save(e);
	}

}
