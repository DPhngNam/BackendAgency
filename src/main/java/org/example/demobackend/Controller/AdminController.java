package org.example.demobackend.Controller;
import org.example.demobackend.Models.Admin;

import org.example.demobackend.Services.AdminServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
     private final AdminServices adminServices;
     public AdminController(AdminServices adminServices) {
         this.adminServices = adminServices;
     }
     @PostMapping("/checkAdmin")
     public boolean checkAdmin(@RequestBody Admin admin) {
         return adminServices.checkAdmin(admin.getUserEmail(), admin.getPassword());
     }
     @PostMapping("/addAdmin")
     public boolean addAdmin(@RequestBody Admin admin) {
         return adminServices.addNewAdmin(admin);
     }
}
