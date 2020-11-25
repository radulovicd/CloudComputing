package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "timesVisited", nullable = false)
    private int timesVisited;

    public Counter() {}

    public Counter(int timesVisited) {
        this.timesVisited = timesVisited;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTimesVisited(int timesVisited) {
        this.timesVisited = timesVisited;
    }

    public int getTimesVisited() {
        return this.timesVisited;
    }

}
