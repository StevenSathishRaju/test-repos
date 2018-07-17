package com.helloGreeting.Controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helloGreeting.Model.Greetings;

@Controller
public class GreetingController {

	private static final String templete= "Hello %s";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting")
	public Greetings greeting(@RequestParam(value="name", defaultValue="world") String name) {
		return  new Greetings(counter.incrementAndGet(), String.format(templete, name));
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "Home page";
	}
}
