package com.tornado.TornadoSerializer.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.tornado.TornadoSerializer.file.Serialize;

@RestController
@RequestMapping(value = "/serialize")
public class CodeGenerationController {
	@Autowired
	Serialize serialize;
	RestTemplate restTemplate = new RestTemplate();

	@GetMapping(value = "/controller")
	public List<String> serializeController() throws RestClientException {
		ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:8082/generate/controller",
				String[].class);
		List<String> employees = Arrays.asList(response.getBody());
		return employees;
	}

	@GetMapping(value = "/controllerAdvice")
	public List<String> serializeControllerAdvice() throws RestClientException {
		ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:8082/generate/controllerAdvice",
				String[].class);
		List<String> employees = Arrays.asList(response.getBody());
		employees.stream().forEach(x -> System.out.println(x));
		return employees;
	}

	@GetMapping(value = "/service")
	public List<String> serializeService() throws RestClientException {
		ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:8082/generate/service",
				String[].class);
		List<String> employees = Arrays.asList(response.getBody());
		employees.stream().forEach(x -> System.out.println(x));
		return employees;
	}

	@GetMapping(value = "/serviceImpl")
	public List<String> serializeServiceImpl() throws RestClientException {
		ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:8082/generate/serviceImpl",
				String[].class);
		List<String> employees = Arrays.asList(response.getBody());
		employees.stream().forEach(x -> System.out.println(x));
		return employees;
	}

	@GetMapping(value = "/filter")
	public List<String> serializeFilter() throws RestClientException {
		ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:8082/generate/filter",
				String[].class);
		List<String> employees = Arrays.asList(response.getBody());
		employees.stream().forEach(x -> System.out.println(x));
		return employees;
	}

	@GetMapping(value = "/repository")
	public List<String> serializeRepository(Class<?> beanClass) throws RestClientException, IOException {
		ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:8082/generate/repository",
				String[].class);
		List<String> employees = Arrays.asList(response.getBody());
		employees.stream().forEach(x -> System.out.println(x));
		return employees;
	}

	@GetMapping(value = "/exceptions")
	public List<String> serializeExceptions() throws RestClientException {
		ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:8082/generate/exceptions",
				String[].class);
		List<String> employees = Arrays.asList(response.getBody());
		employees.stream().forEach(x -> System.out.println(x));
		return employees;
	}

}
