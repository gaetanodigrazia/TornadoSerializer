package com.tornado.TornadoSerializer.serializer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.tornado.TornadoSerializer.file.Serialize;

@Component
public class CodeSerializer {
	@Autowired
	Serialize serialize;
	RestTemplate restTemplate = new RestTemplate();

	public CodeSerializer() {
		
	}
	
	public void serializeController(Class<?> beanClass) throws RestClientException, IOException {
		List<String> toWrite = getResultsList(beanClass, "controller");
		serialize.appendStringFromList(toWrite.get(1), beanClass.getSimpleName(), toWrite);
	}

	public void serializeControllerAdvice(Class<?> beanClass) throws RestClientException, IOException { 
		List<String> toWrite = getResultsList(beanClass, "controllerAdvice");
		serialize.appendStringFromList(toWrite.get(1), beanClass.getSimpleName(), toWrite);
	}

	public void serializeService(Class<?> beanClass) throws RestClientException, IOException {
		List<String> toWrite = getResultsList(beanClass, "service");
		serialize.appendStringFromList(toWrite.get(1), beanClass.getSimpleName(), toWrite);
	}

	public void serializeServiceImpl(Class<?> beanClass) throws RestClientException, IOException {
		List<String> toWrite = getResultsList(beanClass, "serviceImpl");
		serialize.appendStringFromList(toWrite.get(1), beanClass.getSimpleName(), toWrite);

	}

	public void serializeFilter(Class<?> beanClass) throws RestClientException, IOException {
		List<String> toWrite = getResultsList(beanClass, "filter");
		serialize.appendStringFromList(toWrite.get(1), beanClass.getSimpleName(), toWrite);
	}

	public void serializeRepository(Class<?> beanClass) throws RestClientException, IOException {
				List<String> toWrite = getResultsList(beanClass, "repository");
				serialize.appendStringFromList(toWrite.get(1), beanClass.getSimpleName(), toWrite);
	}

	public void serializeExceptions(Class<?> beanClass) throws RestClientException, IOException {
		List<String> toWrite = getResultsList(beanClass, "exceptions");
		serialize.appendStringFromList(toWrite.get(1), beanClass.getSimpleName(), toWrite);
	}
	
	public String[] getResponseEntity(Class<?> beanClass, String componentType){
		return restTemplate.postForObject("http://localhost:8082/generate/"+componentType, beanClass.getClass(),
				String[].class);
	}
	
	public List<String> getResultsList(Class<?> beanClass, String componentType){
		return Arrays.asList(getResponseEntity(beanClass, componentType));
	}

}
