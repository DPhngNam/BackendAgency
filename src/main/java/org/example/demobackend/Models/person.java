package org.example.demobackend.Models;

import jakarta.persistence.*;


@Entity
public class person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "personid")
    private int personid;
    @Column(name = "personlastname")
    private String personlastname;
    @Column(name = "personname")
    private String personname;
    @Column(name = "personsdt")
    private String personsdt;
    @Column(name = "personemail")
    private String personemail;
    @Column(name = "personpassword")
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
