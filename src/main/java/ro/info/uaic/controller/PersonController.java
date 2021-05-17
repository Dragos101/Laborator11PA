package ro.info.uaic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.info.uaic.entity.PersonEnt;
import ro.info.uaic.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/")
    private List<PersonEnt> getAllPersons(){
        return personService.getAllPersons();
    }

    @DeleteMapping("/{personID}")
    private void deletePlayer(@PathVariable("personID") String personID){
        personService.deletePerson(personID);
    }

    @PostMapping("/")
    private String addPlayer(@RequestBody PersonEnt personEnt){
        personService.add(personEnt);
        return personEnt.getId();
    }

    @PutMapping("/")
    private void update(@RequestBody PersonEnt person){
        personService.update(person);
    }

}
