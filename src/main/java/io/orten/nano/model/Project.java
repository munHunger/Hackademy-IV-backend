package io.orten.nano.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "Project")

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectID")
    public long projectID;

    @Column(name = "name")
    public String name;

    @Column(name = "fromDate")
    //@Temporal(TemporalType.DATE)
    public Date fromDate;

    @Column(name = "endDate")
    //@Temporal(TemporalType.DATE)
    public Date endDate;

    @Column(name = "longitude")
    public double longitude;

    @Column(name = "latitude")
    public double latitude;

    @Column(name = "amountToBeRaised")
    public double amountToBeRaised;

    @Column(name = "description")
    public String description;

    @Column(name = "imageOrVideo")
    public String imageOrVideo;

    @Column(name = "projectManager")
    public String projectManager;

    @Column(name = "nationalProject")
    public boolean nationalProject;

    @Column(name = "recurringProject")
    public boolean recurringProject;

    @Column(name = "recurringProjectDate")
    //@Temporal(TemporalType.DATE)
    public Date recurringProjectDate;

    @Column(name = "organizationID")
    public String organizationID;



    public Project(long projectID, String name, Date fromDate, Date endDate, double longitude, double latitude,
                   double amountToBeRaised, String description, String imageOrVideo, String projectManager,
                   boolean nationalProject, boolean recurringProject, Date recurringProjectDate, String organizationID)



    {
        this.projectID = projectID;
        this.name = name;
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.longitude = longitude;
        this.latitude = latitude;
        this.amountToBeRaised = amountToBeRaised;
        this.description = description;
        this.imageOrVideo = imageOrVideo;
        this.projectManager = projectManager;
        this.nationalProject = nationalProject;
        this.recurringProject =recurringProject;
        this.recurringProjectDate = recurringProjectDate;
        this.organizationID = organizationID;
    }

    public Project(){}

}

