package com.tornado.TornadoSerializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tornado.TornadoSerializer"})
public class TornadoSerializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TornadoSerializerApplication.class, args);
	}

}
