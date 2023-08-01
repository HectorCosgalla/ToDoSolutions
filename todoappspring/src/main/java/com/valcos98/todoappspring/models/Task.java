package com.valcos98.todoappspring.models;

import jakarta.persistence.Entity;
import lombok.Getter;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Getter
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "title")
    private String title;

    @Column(name = "isitdone")
    private Boolean isItDone;

    public Task(String title){
        this.title = title;
        this.isItDone = false;
    }

    public Task(){
        this.isItDone = false;
    }

    public void setIsItDone(Boolean isItDone) {
        this.isItDone = isItDone;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
