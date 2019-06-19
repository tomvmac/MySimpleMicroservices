package com.tom.mygreeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@GetMapping("/greet/name/{yourName}")
	public String getGreeting(@PathVariable("yourName") String yourName){
		String yourNameLowerCase = yourName.toLowerCase();
		
		if (yourNameLowerCase.equals("kobe")){
			return "Mamba is the best Laker ever and is the GOAT!";
		}
		if (yourNameLowerCase.equals("jordan")){
			return "Mike is the best Bull ever and is the GOAT!";
		}
		if (yourNameLowerCase.equals("tom")){
			return "Get that job at Fitbit dude!";
		}
		return "Thanks for visiting, peace out.";
	}
	
}
