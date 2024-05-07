package com.example.demo.Models.RetailerUser;

import com.example.demo.Models.person;

public interface PersonBulder {
    PersonBulder setOwnerId(int ownerId);
    PersonBulder setOwnerLastName(String ownerLastName);
    PersonBulder setOwnerName(String ownerName);
    PersonBulder setOwnerSdt(String ownerSdt);
    PersonBulder setOwnerEmail(String ownerEmail);
    PersonBulder setPassword(String password);
    person build();
}
