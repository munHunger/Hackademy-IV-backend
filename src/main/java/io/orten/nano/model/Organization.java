package io.orten.nano.model;

import javax.persistence.*;
/**
 *represents an organization raising fund for one or more projects
 */
@Entity
@Table(name="organization")
public class Organization {
    @Id
    public String organizationID;
    public String name;
    public String address;
    public String contactPersonName;
    public String contactPersonEmail;
    public String accountNumber;
    public String billingInformation;
    public String description;
    public String password;

    /**
     * default constructor required by hibernate
     */

    public Organization()
    {

    }

    /**
     *  Bussiness Constructor
     */
    public Organization(String organizationID, String organizationName, String organizationAddress, String contactPersonName, String contactPersonEmail, String accountNumber, String billingInformation, String description) {
        this.organizationID = organizationID;
        this.name = organizationName;
        this.address = organizationAddress;
        this.contactPersonName = contactPersonName;
        this.contactPersonEmail = contactPersonEmail;
        this.accountNumber = accountNumber;
        this.billingInformation = billingInformation;
        this.description = description;

    }
}

