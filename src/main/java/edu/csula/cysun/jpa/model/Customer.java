package edu.csula.cysun.jpa.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {

    @Id
    private Integer id;

    private String name;

    @Transient
    private String address;

    @ElementCollection
    @OrderColumn
    private List<String> phones;

    public Customer() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

}
