package com.testing.demo2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
class Demo2Application{

	@GetMapping("/hello2")
	fun helloworld():String{
		return "hello world2"
	}
}

fun main(args: Array<String>) {
	runApplication<Demo2Application>(*args)
}
