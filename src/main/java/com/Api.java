package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Api {
	@GetMapping("/hello")
	public String hello(String a) {
		return "hello "+a;
	}
	@GetMapping("/fruit")
	public String fruit(String a) {
		return "i like "+a;
	}
	@GetMapping("/num")
	public String num(int e) {
		return "lucky number "+ e;
	}
	@GetMapping("/color")
	public String color(String q) {
		return "fav color "+q;
	}
	@GetMapping("/bye")
	public String bye() {
		return "Good bye";
	}

}
