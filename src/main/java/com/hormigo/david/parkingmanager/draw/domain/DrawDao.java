package com.hormigo.david.parkingmanager.draw.domain;

import java.util.Date;

public class DrawDao {
    private String description;
    private Status status;
    private Date creationDate;

    /**
     * Fecha en la que ha sido sorteado
     */
    private Date drawDate;

    public DrawDao() {
        this("",Status.NEW);
    }
    public DrawDao(String description, Status status) {
        this.description = description;
        this.status = status;
        this.creationDate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public Date getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(Date drawDate) {
        this.drawDate = drawDate;
    }
}
