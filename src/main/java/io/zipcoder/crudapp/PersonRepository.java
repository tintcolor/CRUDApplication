package io.zipcoder.crudapp;


import org.springframework.data.repository.CrudRepository;


import java.util.List;

/**
 * Created by anthonyjones on 6/15/17.
 */


public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findByLastName(String lastname);

}
