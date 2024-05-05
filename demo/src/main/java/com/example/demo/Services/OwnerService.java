package com.example.demo.Services;

import com.example.demo.Models.RetailerUser.person;
import com.example.demo.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OwnerService {
    private static OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public static List<person> getUserList() {
        // Lấy ra từ Repository dạng List<User> là Entity
        List<person> users = (List<person>) ownerRepository.findAll();

        // Biển đổi List<Entity> thành List<Model> (xem ở constructor của UserModel có code copy dữ liệu)
        List<person> personModels = StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());

        return personModels;
    }
}
