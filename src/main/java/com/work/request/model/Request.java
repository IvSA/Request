package com.work.request.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "requests")
public class Request {

    //public static final String STATUS = StatusEnum.NEW.getStatus();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    @NotBlank
    private String description;

    @Column(columnDefinition = "status")
    @ColumnDefault("Новая")
    private String status;

    public Request() {
    }

    public Request(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
