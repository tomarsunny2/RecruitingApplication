package com.app.recruitingApp.model;

import com.app.recruitingApp.util.ApplicationEventListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.*;
/*
* Application Entity mapped to application table
*/
@Entity
@Table(name = "Application", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"candidateEmail", "jobId"})})
@Data
@EntityListeners(ApplicationEventListener.class)
public class Application {

    @Id
    @Column(name = "applicationId", columnDefinition = "int(11)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer applicationId;

    @Column(name = "candidateEmail", columnDefinition = "varchar(50)")
    private String candidateEmail;

    @Column(name = "resumeText", columnDefinition = "text")
    private String resumeText;

    @Column(name = "applicationStatus", columnDefinition = "varchar(20)")
    private String applicationStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "jobId", nullable = false)
    @JsonIgnore
    private Offer offer;

}
