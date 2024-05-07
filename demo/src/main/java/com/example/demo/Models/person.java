package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personid;
    private String personlastname;
    private String personname;
    private String personsdt;
    private String personemail;
    private String personpassword;

    public person(){

    }

    public person(String personlastname, String personname, String personsdt, String personemail, String personpassword) {
        this.personlastname = personlastname;
        this.personname = personname;
        this.personsdt = personsdt;
        this.personemail = personemail;
        this.personpassword = personpassword;
    }

    public int getPersonid() {
        return personid;
    }

    public String getPersonlastname() {
        return personlastname;
    }

    public String getPersonname() {
        return personname;
    }

    public String getPersonsdt() {
        return personsdt;
    }

    public String getPersonemail() {
        return personemail;
    }

    public String getPersonpassword() {
        return personpassword;
    }
}
