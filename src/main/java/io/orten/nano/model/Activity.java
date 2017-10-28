package io.orten.nano.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activityId")
    private long activityId;
    @Column(name = "projectId")
    private long projectId;
    @Column(name = "activityTitle")
    private String activityTitle;
    @Column(name = "activityDescription")
    private String activityDescription;
    @Column(name = "activityDate")
    private Date activityDate;
    @Column(name = "activityImage")
    private String activityImage;

    public Activity(){}

    public long getActivityId() {return activityId;}
    public void setActivityId(long activityId) {this.activityId = activityId;}
    public Long getProjectId() {return projectId;}
    public void setProjectId(Long projectID) {this.projectId = projectID;}
    public String getActivityTitle() {return activityTitle;}
    public void setActivityTitle(String activityTitle) {this.activityTitle = activityTitle;}
    public String getActivityDescription() {return activityDescription;}
    public void setActivityDescription(String activityDescription) {this.activityDescription = activityDescription;}
    public Date getActivityDate() {return activityDate;}
    public void setActivityDate(Date activityDate) {this.activityDate = activityDate;}
    public String getActivityImage() {return activityImage;}
    public void setActivityImage(String activityImage) {this.activityImage = activityImage;}
}