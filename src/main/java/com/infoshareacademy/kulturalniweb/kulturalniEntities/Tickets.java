package com.infoshareacademy.kulturalniweb.kulturalniEntities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tickets {

    @Id
    private Long id;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
