package io.orten.nano.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")

public class Organization {
    @Id
    @Column(name="organizationID")
    public String organizationID;
    @Column(name="name")
    public String name;
    @Column(name="address")
    public String address;
    @Column(name="contactPerson")
    public String contactPerson;
    @Column(name="contactPersonEmail")
    public String contactPersonEmail;
    @Column(name="password")
    public String password;
    @Column(name="billingInformation")
    public String billingInformation;
    @Column(name="accountNumber")
    public String accountNumber;
    @Column(name="description")
    public String description;

    public Organization(){}

    public Organization(String organizationID, String name, String address, String contactPerson,
                        String contactPersonEmail, String password, String billingInformation,
                        String accountNumber, String description)
    {
        this.organizationID = organizationID;
        this.name = name;
        this.address = address;
        this.contactPerson = contactPerson;
        this.contactPersonEmail = contactPersonEmail;
        this.password = password;
        this.billingInformation = billingInformation;
        this.accountNumber = accountNumber;
        this.description = description;
    }
}