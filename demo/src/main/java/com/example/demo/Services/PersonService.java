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

    public static List<person> getUserList() {
        // Lấy ra từ Repository dạng List<User> là Entity
        List<person> users = (List<person>) personRepository.findAll();

        // Biển đổi List<Entity> thành List<Model> (xem ở constructor của UserModel có code copy dữ liệu)
        List<person> personModels = StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());

        return personModels;
    }

    public static List<person> getUserByEmail(String email) {
        // Lấy ra từ Repository dạng List<User> là Entity
        List<person> users = (List<person>) personRepository.getUserByEmail(email);

        // Biển đổi List<Entity> thành List<Model> (xem ở constructor của UserModel có code copy dữ liệu)
        List<person> personModels = StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());

        return personModels;
    }
}
