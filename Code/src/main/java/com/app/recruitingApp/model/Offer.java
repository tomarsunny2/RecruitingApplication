package com.app.recruitingApp.model;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;
/*
* Offer Entity mapped to Offer table
*/
@Data
@Entity
@Table(name = "Offer")
public class Offer {

    @Id
    @Column(name = "jobId", columnDefinition = "int(11)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int jobId;

    @Column(name = "jobTitle", columnDefinition = "varchar(50)", unique = true)
    private String jobTitle;

    @Column(name = "startDate")
    private Date startDate;

    private transient Integer numberOfApplications;

    
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "offer")
    private List<Application> applications=Collections.EMPTY_LIST;

   

    public Integer getNumberOfApplications() {
        return this.getApplications() != null ? this.getApplications().size() : 0;
    }

}
