package springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping(path="/leaders")
	public String forManagers() {
		
		return "leaders";
	}
	
	@GetMapping(path="/systems")
	public String forAdmins() {
		
		return "systems";
	}
}
