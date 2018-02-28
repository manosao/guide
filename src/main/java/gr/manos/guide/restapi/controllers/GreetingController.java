package gr.manos.guide.restapi.controllers;

import gr.manos.guide.restapi.models.Greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/greeting")
public class GreetingController {

	private static final Logger log = LoggerFactory.getLogger("GreetingLogger");
	
	@GetMapping(value="/world")
//	@PreAuthorize("hasRole('ADMIN')")
    public Greeting helloWorld() {
		Greeting greeting = Greeting.builder().message("Hello World!").build();
		log.info(greeting.getMessage());
        return greeting;
    }
	
	@GetMapping(value="/person/{name}")
	public Greeting helloPerson(@PathVariable String name) {
		Greeting greeting = Greeting.builder().message("Hello "+name+"!").build();
		return greeting;
	}
	
	@GetMapping(value="/anyone")
	public Greeting helloPersonOptional(@RequestParam(value="name", defaultValue="Anonymous") String name) {
		Greeting greeting = Greeting.builder().message("Hello "+name+"!").build();
		return greeting;
	}
	
	@PostMapping(value="/custom")
	public Greeting helloPersonPost(@RequestBody Greeting greeting) {
		Greeting greetingResposne = Greeting.builder().message("Your greeting: "+greeting.getMessage() ).build();
		return greetingResposne;
	}

}
