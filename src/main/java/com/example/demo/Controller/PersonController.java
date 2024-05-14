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

    @GetMapping("/findByNameSimilarity")
    public ResponseEntity<List<person>> findByNameSimilarity(@RequestParam String personName) {
        List<person> result = PersonService.findByNameSimilarity(personName);
        if (!result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
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
