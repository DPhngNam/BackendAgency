package com.example.demo.Services;

import com.example.demo.Models.person;
import com.example.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonService {
    private static PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static person getUserByEmail(String personemail) {
        return personRepository.getUserByEmail(personemail);
    }

    public static person createPerson(person newPerson) {
        return personRepository.save(newPerson);
    }
}
