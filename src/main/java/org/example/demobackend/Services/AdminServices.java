package org.example.demobackend.Services;

import org.example.demobackend.Models.Admin;
import org.example.demobackend.Repository.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {
    private final AdminRepository adminRepository;

    public AdminServices(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public boolean checkAdmin(String userEmail, String password) {
        return adminRepository.findByUserEmail(userEmail).getPassword().equals(password);
    }

    public boolean addNewAdmin(Admin admin){
        try {
            adminRepository.save(admin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
