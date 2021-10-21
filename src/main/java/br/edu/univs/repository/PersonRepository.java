package br.edu.univs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.univs.data.model.Person;

@Repository
public interface PersonRepository 
extends JpaRepository<Person, Long>{
	
	@Query("SELECT p FROM Person p WHERE p.firstName =:firstName")
	Person findByFirstName(
			@Param("firstName") String firstName);

}
