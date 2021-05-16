package ro.info.uaic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.info.uaic.entity.PersonEnt;
import ro.info.uaic.service.PersonService;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    private List<PersonEnt> getAllPersons(){
        return personService.getAllPersons();
    }

    @DeleteMapping("persons/{personID}")
    private void deletePlayer(@PathVariable("personID") String personID){
        personService.deletePerson(personID);
    }

    @PostMapping("persons")
    private String addPlayer(@RequestBody PersonEnt personEnt){
        personService.ADD(personEnt);
        return personEnt.getId();
    }

    @PutMapping("/persons/{personID}")
    private void update(@RequestBody PersonEnt person, @PathVariable("personID") String personID){
        personService.update(person, personID);
    }

}
