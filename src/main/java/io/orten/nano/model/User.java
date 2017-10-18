package io.orten.nano.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * represents a donor
 */
@Entity
@Table
public class User {

        @Id
        private String userID;
        private String firstName;
        private String lastName;

        @OneToMany
        private List<Project> fundedProjects;

        /**
         * default constructor required by hibernate
         */
        public User(){

        }

        /**
         * business constructor
         */
        public User(String userID, String firstName, String lastName, List<Project> fundedProjects) {
            this.userID = userID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.fundedProjects = fundedProjects;
        }

        /**
         * getters methods
         */
        public String getUserID() {
            return userID;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public List<Project> getFundedProjects() {
            return fundedProjects;
        }

        /**
         * setter methods
         */
        public void setUserID(String userID) {
            this.userID = userID;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setFundedProjects(List<Project> fundedProjects) {
            this.fundedProjects = fundedProjects;
        }
    }


