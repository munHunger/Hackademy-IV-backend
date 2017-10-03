package io.orten.nano.model;

import javax.persistence.*;

@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name="organization_id")
    public String organizationId;
    @Column(name="name")
    public String name;
    @Column(name="address")
    public String address;
    @Column(name="contact_Person_name")
    public String contactPersonName;
    @Column(name="contact_person_Phone_Number")
    public String contactPersonTelephone;
    @Column(name="contact_person_email")
    public String contactPersonEmail;
    @Column(name="password")
    public String password;
    @Column(name="billing_information")
    public String billingInformation;
    @Column(name="account_number")
    public String accountNumber;
    @Column(name="description")
    public String description;

    public Organization()
    {

    }

    public Organization(String organizationId, String name, String address, String contactPersonName,
                        String contactPersonTelephone, String contactPersonEmail, String password, String billingInformation,
                        String accountNumber, String description) {
        this.organizationId = organizationId;
        this.name = name;
        this.address = address;
        this.contactPersonName = contactPersonName;
        this.contactPersonTelephone = contactPersonTelephone;
        this.contactPersonEmail = contactPersonEmail;
        this.password = password;
        this.billingInformation = billingInformation;
        this.accountNumber = accountNumber;
        this.description = description;
    }

    /* create a constructor takes values */

}
