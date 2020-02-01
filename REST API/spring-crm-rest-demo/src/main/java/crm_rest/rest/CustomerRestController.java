package crm_rest.rest;

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

import crm_rest.entity.Customer;
import crm_rest.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		if(customerService.getCustomer(customerId)==null)
			throw new CustomerNotFoundException(
					"The customer with id "+customerId+" was not found in database.");
			
		return customerService.getCustomer(customerId);
		
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer c) {
		
		c.setId(0);
		
		customerService.saveCustomer(c);
		
		return c;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer c) {
		
		customerService.saveCustomer(c);
		
		return c;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable int id) {
		
	if(customerService.getCustomer(id)==null)
		throw new CustomerNotFoundException(
			"The customer with id "+id+" was not found in database.");
		
		customerService.deleteCustomer(id);
		
		return "Deleted customer id - "+id;
	}
}
