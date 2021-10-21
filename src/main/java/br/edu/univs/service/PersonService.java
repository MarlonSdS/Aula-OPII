package br.edu.univs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univs.data.model.Person;
import br.edu.univs.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public PersonService(PersonRepository repository) {
		this.repository = repository;
	}

	public List<Person> findAll() {
		return repository.findAll();
	}

	public Person findById(String id) {
		Person entity = repository.findById(Long.parseLong(id)).orElse(null);
		return entity;
	}

	public Person create(Person person) {
		var entity = repository.save(person);
		return entity;
	}

	public void delete(Long id) {
		var entity = repository.findById(id).orElse(null);
		repository.delete(entity);
	}

}
