package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calc {
	
	@GetMapping("/sum")
	public int sum(int a, int b) {
		return a+b;
	}
	@GetMapping("/sub")
	public int sub(int a, int b) {
		return a-b;
	}
	@GetMapping("/mul")
	public int mul(int a, int b) {
		return a*b;
	}
	@GetMapping("div")
	public float div(int a, int b) {
		return a/b;
	}
	@GetMapping("/mod")
	public float mod(int a, int b) {
		return a%b;
	}
}
