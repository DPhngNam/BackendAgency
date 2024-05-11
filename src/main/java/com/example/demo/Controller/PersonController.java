package com.example.demo.Controller;

import com.example.demo.Models.person;
import com.example.demo.Services.PersonService;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping(path="/allUser")
    public ResponseEntity<String> getUserByEmail(@RequestParam String personemail) {
        person user = PersonService.getUserByEmail(personemail);
        if(user != null) {
            return new ResponseEntity<>(String.valueOf(user.getPPersonid()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createPerson")
    public ResponseEntity<Object> createPerson(@RequestBody person newPerson) {
        String temp = newPerson.getPersonpassword();
        newPerson.setPersonpassword(PersonService.hashPassword(temp));
        if (PersonService.createPerson(newPerson)) {
            return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Create failed", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByNameSimilarity")
    public ResponseEntity<List<person>> findByNameSimilarity(@RequestParam String personName) {
        List<person> result = PersonService.findByNameSimilarity(personName);
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }
}
