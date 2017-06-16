package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController

@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @RequestMapping("/getPerson")
    public String getPerson() {
        return "<h1>John</h1>";
    }


    @RequestMapping(value = "/getPerson_POSTMETHOD", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Person getPerson_POSTMETHOD(@RequestBody Person person) {
        return person;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Person>> getPeople() {
        return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@PathVariable int id) {
        Person person = personRepo.findOne(id);

        if (person != null) {
            return new ResponseEntity<>(personRepo.findOne(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Person) null, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
    }

    @RequestMapping( value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        personRepo.delete(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}



