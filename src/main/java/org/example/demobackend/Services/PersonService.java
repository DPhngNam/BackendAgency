package org.example.demobackend.Services;

import org.example.demobackend.Models.person;
import org.example.demobackend.Repository.PersonRepository;
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

    public static person getUserByEmail(String personemail, String personpassword) {
        person user = personRepository.getUserByEmail(personemail);
        if(user == null){
            return null;
        }
        else if(user.getPersonpassword().equals(personpassword)){
            return user;
        }
        return null;
    }

    public static Boolean createPerson(person newPerson) {
        personRepository.save(newPerson);
        return true;
    }

    public static List<person> findByNameSimilarity(String personname) {
        return StreamSupport.stream(personRepository.findByNameSimilarity(personname).spliterator(), false)
                .collect(Collectors.toList());
    }

    public static Boolean existsByEmail(String personemail) {
        return personRepository.existsByEmail(personemail) != null;
    }

}
