package com.hormigo.david.parkingmanager.user.domain;

import jakarta.persistence.Column;
import java.util.Set;

import com.hormigo.david.parkingmanager.draw.domain.Draw;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String email;
    private String name;
    private String lastName1;
    private String lastName2;
    private Role role;

    @ManyToMany
    @JoinTable(name = "users_included",
    joinColumns = @JoinColumn(name="user_id"),
     inverseJoinColumns = @JoinColumn(name="draw_id"))
    private Set<Draw> includedIn;

    public User(String email, String name, String lastName1, Role role) {
        this(email,name,lastName1,"",role);
    }
    public User(String email, String name, String lastName1, String lastName2, Role role) {
        this.email = email;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.role = role;
    }
    /**
     * 
     */
    public User() {
        this("","","",null);
    }

    /**
     * @return identif
     */
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName1() {
        return lastName1;
    }
    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }
    public String getLastName2() {
        return lastName2;
    }
    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

}
