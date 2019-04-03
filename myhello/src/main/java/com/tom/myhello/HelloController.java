package com.tom.myhello;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hello")
	public String sayHello(){
		return "Hello Tom!";
	}
	
	@GetMapping("/hello/name/{yourName}")
	public String sayHello(@PathVariable("yourName") String yourName){
		return "Hello " + yourName + ".  " + getGreeting(yourName);
	}
	
	@GetMapping("/config")
	public String showConfig(){
		
		String greetingUrl = env.getProperty("mygreeting.url");
		//String greetingPort = env.getProperty("mygreeting.port");
		
		return "greetingUrl = " + greetingUrl;
	}
	
	
	private String getGreeting(String yourName){
		
		String returnGreeting = "Default Greeting"; 
		
		// greeting url info from application.properties
		String greetingUrl = env.getProperty("mygreeting.url");
		//String greetingPort = env.getProperty("mygreeting.port");
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("yourName", yourName);
		
		String url = "http://" + greetingUrl + "/greet/name/{yourName}";
		
		returnGreeting = restTemplate.getForObject(url, String.class, uriVariables);
		
		return returnGreeting;
		
	}
	
	private String mockedGreeting(String yourName){
		if (yourName.equalsIgnoreCase("kobe")){
			return "You are the MVP!";
		}
		return "Thanks for visiting.";
	}
	
	
}
