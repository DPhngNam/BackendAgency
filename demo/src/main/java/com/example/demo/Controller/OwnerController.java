package com.example.demo.Controller;

import com.example.demo.Models.RetailerUser.PersonBulder;
import com.example.demo.Models.RetailerUser.PersonConcreteBuilder;
import com.example.demo.Models.RetailerUser.person;
import com.example.demo.Repository.OwnerRepository;
import com.example.demo.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user") //http://localhost:8080/user/hello
public class OwnerController {
    @Autowired
    private final OwnerService ownerService;

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

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    //
//
//    @PostMapping(path="/addNewPerson")
//    public @ResponseBody String addNewPerson(@RequestParam String personlastname, @RequestParam String personname, @RequestParam String personsdt, @RequestParam String personemail, @RequestParam String personpassword) {
//        try {
//            // Enable IDENTITY_INSERT
//
//            // Build the person object
//            PersonBulder owner = new PersonConcreteBuilder()
//                    .setOwnerLastName(personlastname)
//                    .setOwnerName(personname)
//                    .setOwnerSdt(personsdt)
//                    .setOwnerEmail(personemail)
//                    .setPassword(personpassword);
//
//            person p = owner.build();
//
//            // Save the person object
//            ownerRepository.save(p);
//
//            // Disable IDENTITY_INSERT
//
//            return "Saved";
//        } catch (Exception e) {
//            return "Error: " + e.getMessage();
//        }
//    }
    @GetMapping(path="/all")
    public ResponseEntity<List<person>> getUserList() {
        // Service trả về Model (là List<UserModel>) nên có thể return thẳng luôn
        return new ResponseEntity<List<person>> (OwnerService.getUserList(), HttpStatus.OK);
    }

}
