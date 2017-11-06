package io.orten.nano.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactionID")
    public int transactionID;

    @Column(name = "amount")
    public float amount;

    @Column(name = "transactionDate")
    public Date transactionDate;

    //@Column(name = "projectID")
    //public int projectID;

    //@Column(name = "donorID")
    //public int donorID;

    @ManyToOne
    @JoinColumn(name="donorID", insertable = false, updatable = false, nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "projectID",nullable = false)
    @JsonIgnore
    public Project project;


    public Transaction(){
        //user =new User();
        //project=new Project();

    }


}
