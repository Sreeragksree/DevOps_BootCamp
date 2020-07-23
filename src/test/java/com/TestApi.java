package com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)

@SpringBootTest
public class TestApi {
	Api ms = new Api();
	Calc cl = new Calc();
	@Test
	public void testHello() {
		
		Assertions.assertEquals(ms.hello("sreerag"), "hello sreerag");
	}
	@Test
	public void testFruit() {
		
		Assertions.assertEquals(ms.fruit("apple"), "i like apple");
	}
	@Test
	public void testNum() {
		
		Assertions.assertEquals(ms.num(1), "lucky number 1");
	}
	@Test
	public void testPrice() {
		
		Assertions.assertEquals(ms.color("orange"), "fav color orange");
	}
	@Test
	public void testbye() {
		
		Assertions.assertEquals(ms.bye(), "Good bye");
	}
	@Test
	public void testsum() {
		
		Assertions.assertEquals(cl.sum(10, 20),30);
	}
	@Test
	public void testsub() {
		
		Assertions.assertEquals(cl.sub(100, 20),80);
	}
	@Test
	public void testmul() {
		
		Assertions.assertEquals(cl.mul(10, 6),60);
	}
	@Test
	public void testdiv() {
		
		Assertions.assertEquals(cl.div(80, 4),20);
	}
	@Test
	public void testmod() {
		
		Assertions.assertEquals(cl.mod(105, 20),5);
	}
}