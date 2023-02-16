package br.com.javaspring;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Gretting greeting(
			@RequestParam(value = "name", defaultValue = "World") 
			String name) {
		return new Gretting(counter.incrementAndGet(), String.format(template, name));
	}
	
}
