package payroll;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository rep) {
		return args -> {
			System.out.println("Preloading "+ rep.save(
					new Employee("Bilbo", "Baggins", "burglar")));
			System.out.println("Preloading "+ rep.save(
					new Employee("Frodo", "Baggins", "ring barrow")));
		};
	}
	
	
	
}
