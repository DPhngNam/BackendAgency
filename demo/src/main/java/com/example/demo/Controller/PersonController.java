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

//    @GetMapping(path="/alltest")
//    public @ResponseBody Iterable<person> getUserByName(@RequestParam String personname) {
//        return ownerRepository.getUserByName(personname);
//    }
//
//    @GetMapping(path="/byId")
//    public @ResponseBody Iterable<person> getUserById(@RequestParam int userId) {
//        return ownerRepository.getUserById(userId);
//    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    //

//    @PostMapping(path="/addNewPerson")
//    public @ResponseBody String addNewPerson(@RequestBody person P) {
//
//    }
    @GetMapping(path="/all")
    public ResponseEntity<List<person>> getUserList() {
        // Service trả về Model (là List<UserModel>) nên có thể return thẳng luôn
        return new ResponseEntity<List<person>> (PersonService.getUserList(), HttpStatus.OK);
    }

    @GetMapping(path="/allUser")
    public ResponseEntity<person> getUserByEmail(@RequestParam String email) {

        List<person> user = PersonService.getUserByEmail(email);
        if (user != null) {
            return new ResponseEntity<person>((person) user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

}
