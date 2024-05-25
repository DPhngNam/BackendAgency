package org.example.demobackend.Controller;


import org.example.demobackend.Models.person;
import org.example.demobackend.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user") //http://localhost:8080/user/hello
public class PersonController {
    @Autowired
    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/createPerson")
    public ResponseEntity<String> createPerson(@RequestBody person newPerson) {
        if (PersonService.existsByEmail(newPerson.getPersonemail())) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        } else {
            if (PersonService.createPerson(newPerson)) {
                System.out.println("Person created");
                return new ResponseEntity<>(String.valueOf(newPerson.getPPersonid()), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Create failed", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping(path="/getLoginUser")
    public ResponseEntity<Object> getUserByEmail(@RequestParam String personemail,@RequestParam String personpassword) {
        person user = PersonService.getUserByEmail(personemail,personpassword);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
}
