package com.amitph.spring.dogs.web;

import com.amitph.spring.dogs.model.DogDto;
import com.amitph.spring.dogs.repo.Dog;
import com.amitph.spring.dogs.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogsController {

	@Autowired
	Environment env;

	@Autowired
	DogsService service;

	@GetMapping
	public List<Dog> getDogs() {
		System.out.println(env.getProperty("payment.url"));
		return service.getDogs();
	}

	@PostMapping
	public void postDogs(@RequestBody DogDto dto) {
		service.add(dto);
	}

	@GetMapping("/{id}")
	public Dog getById(@PathVariable(required = true) long id) {
		return service.getDogById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable(required = true) long id) {
		service.delete(id);
	}
}
