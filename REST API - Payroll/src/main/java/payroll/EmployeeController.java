package payroll;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.methodOn;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	private final EmployeeRepository rep;
	
	EmployeeController(EmployeeRepository rep){
		this.rep=rep;
	}
	
	
	@GetMapping("/employees")
	CollectionModel<EntityModel<Employee>> all(){
		
		List<EntityModel<Employee>> employees = rep.findAll().stream()
			    .map(employee -> new EntityModel<>(employee,
			    	      linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
			    	      linkTo(methodOn(EmployeeController.class).all()).withRel("employees")))
			    	    .collect(Collectors.toList());
		
		return new CollectionModel<>(employees,
			    linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
	}
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee x) throws URISyntaxException {
		
		return rep.save(x);
	}
	
	@GetMapping("/employees/{id}")
	EntityModel<Employee> one(@PathVariable Long id) {
		Employee e = rep.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
		
		return new EntityModel<>(e,
			      linkTo(methodOn(EmployeeController.class).one(e.getId())).withSelfRel(),
			      linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
				
	}
	
	@PutMapping("/employees/{id}")
	ResponseEntity<?> replace(@RequestBody Employee e, @PathVariable Long id) {
		
		Employee updatedEmployee = rep.findById(id)
				.map(employee -> {
					employee.setName(e.getName());
					employee.setRole(e.getRole());
					return rep.save(employee);
				})
				.orElseGet(() -> {
					e.setId(id);
					return rep.save(e);
				});
		
		EntityModel<Employee> resource = new EntityModel<>(updatedEmployee,
			      linkTo(methodOn(EmployeeController.class).one(e.getId())).withSelfRel(),
			      linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
		
		return ResponseEntity.ok(resource);
		
			
	}
	
	@DeleteMapping("/employees/{id}")
	ResponseEntity<?> delete(@PathVariable Long id) {
		rep.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	
}

