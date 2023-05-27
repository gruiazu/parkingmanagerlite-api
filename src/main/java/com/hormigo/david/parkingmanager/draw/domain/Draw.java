package com.hormigo.david.parkingmanager.draw.domain;

import java.util.Date;
import java.util.Set;

import com.hormigo.david.parkingmanager.user.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Draw {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private Status status;
    private final Date creationDate;
    @ManyToMany(mappedBy = "includedIn")
    private Set<User> usersIncluded;
    public Set<User> getUsersIncluded() {
        return usersIncluded;
    }
    
    public void setUsersIncluded(Set<User> usersIncluded) {
        this.usersIncluded = usersIncluded;
    }
    /**
     * Fecha en la que ha sido sorteado
     */
    private Date drawDate;

    public Draw() {
        this("");
    }

    public Draw(String description) {
        this(description,Status.NEW);
    }

    public Draw(String description, Status status) {
        this.description = description;
        this.status = status;
        this.creationDate = new Date();
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }

    public Date getDrawDate() {
        return drawDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
