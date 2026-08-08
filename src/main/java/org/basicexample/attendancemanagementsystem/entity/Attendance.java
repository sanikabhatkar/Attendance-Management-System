package org.basicexample.attendancemanagementsystem.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String status; // if the student is present or not

    @Column(nullable = false)
    private String remarks; // if the student came on time or late


    @Column(nullable = false, updatable = false) // updatable = false means once the value is stored in the database, Hibernate will never update it.
    private LocalDate date;

    @PrePersist
    public void setDate() {
        this.date = LocalDate.now();
        // here the date will automatically be updated in the database and since updatable = false, it cannot be changed!
    }

    public Attendance(Integer id, String name, String status, String remarks, LocalDate date) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.remarks = remarks;
        this.date = date;
    }

    public Attendance() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
        // here, the user will provide the date
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

/*
    Code :
    @PrePersist
    public void setDate() {
        this.date = LocalDate.now();
    }

    Here, the annotation PrePersist means : Pre ( Before ) and Persist ( Save into the database )
 */