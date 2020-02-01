package springboot.example.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello World! FIZZ BUZZ! Time on server is "+LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "Run a hard 5k!";
	}
}
