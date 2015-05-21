package demo;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
    String home() {
        return "Hello Nesreen - from Spring Boot first app!";
    }
}


