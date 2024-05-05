package com.example.demo.Models.RetailerUser;

public class PersonConcreteBuilder implements PersonBulder {
    private int personid;
    private String personlastname;
    private String personname;
    private String personsdt;
    private String personemail;
    private String personpassword;


    @Override
    public PersonBulder setOwnerId(int ownerId) {
        this.personid = ownerId;
        return this;
    }

    @Override
    public PersonBulder setOwnerLastName(String ownerLastName) {
        this.personlastname = ownerLastName;
        return this;
    }

    @Override
    public PersonBulder setOwnerName(String ownerName) {
        this.personname = ownerName;
        return this;
    }

    @Override
    public PersonBulder setOwnerSdt(String ownerSdt) {
        this.personsdt = ownerSdt;
        return this;
    }

    @Override
    public PersonBulder setOwnerEmail(String ownerEmail) {
        this.personemail = ownerEmail;
        return this;
    }

    @Override
    public PersonBulder setPassword(String password) {
        this.personpassword = password;
        return this;
    }

    @Override
    public person build() {
        return new person(personlastname, personname, personsdt, personemail, personpassword);
    }
}
