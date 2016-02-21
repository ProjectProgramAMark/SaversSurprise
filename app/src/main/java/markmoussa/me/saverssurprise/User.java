package markmoussa.me.saverssurprise;

import java.util.ArrayList;

public class User {
    private String email;
    private String password;
    private String city;
    private String street;
    private String state;
    private String zip;
    private String phone;
    private String uid;
    private Products products;
    private Double amountSaved;

    public User() {}
    public User(String email, String password, String street, String city, String state, String zip, String phone, String uid, Double amountSaved) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.uid = uid;
//        this.products = products;
        this.email = email;
        this.password = password;
        this.amountSaved = amountSaved;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getPhone() {
        return phone;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getAmountSaved() {
        return amountSaved;
    }

    public Products getProducts() {
        return products;
    }

    public void setAmountSaved(double amountSaved) {
        this.amountSaved = amountSaved;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
