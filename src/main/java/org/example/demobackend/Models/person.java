package org.example.demobackend.Models;

import jakarta.persistence.*;


@Entity
public class person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "personid")
    private int personid;
    @Column(name = "personlastname",nullable = false,columnDefinition = "NVARCHAR(255)")
    private String personlastname;
    @Column(name = "personname",nullable = false,columnDefinition = "NVARCHAR(255)")
    private String personname;
    @Column(name = "personsdt",nullable = false)
    private String personsdt;
    @Column(name = "personemail",nullable = false,unique = true)
    private String personemail;
    @Column(name = "personpassword",nullable = false)
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

    public int getPPersonid() {
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

    public void setPersonlastname(String personlastname) {
        this.personlastname = personlastname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public void setPersonsdt(String personsdt) {
        this.personsdt = personsdt;
    }

    public void setPersonemail(String personemail) {
        this.personemail = personemail;
    }

    public void setPersonpassword(String personpassword) {
        this.personpassword = personpassword;
    }

}
