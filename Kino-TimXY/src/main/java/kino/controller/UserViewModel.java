package kino.controller;

import kino.model.entities.User;

public class UserViewModel {
    private Integer id;

    private String name;

    private String address;

    private String email;

    private String number;

    private boolean admin;

    public UserViewModel(User user) {
        this.id=user.getId();
        this.address=user.getAddress();
        this.name=user.getName();
        this.email=user.getEmail();
        this.number=user.getNumber();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
