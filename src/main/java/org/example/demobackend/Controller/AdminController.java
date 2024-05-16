package org.example.demobackend.Controller;
import org.example.demobackend.Models.Admin;

import org.example.demobackend.Services.AdminServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
     private final AdminServices adminServices;
     public AdminController(AdminServices adminServices) {
         this.adminServices = adminServices;
     }
     @GetMapping("/checkAdmin")
     public boolean checkAdmin(@RequestParam String userEmail, @RequestParam String password) {
         return adminServices.checkAdmin(userEmail, password);
     }
     @PostMapping("/addAdmin")
     public boolean addAdmin(@RequestBody Admin admin) {
         return adminServices.addNewAdmin(admin);
     }
}
