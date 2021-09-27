package com.example.myapplication;

public class VanillaHelper {
    String username, address, number, items;

    public VanillaHelper(String username, String address, String number, String items) {
        this.username = username;
        this.address = address;
        this.number = number;
        this.items = items;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }
}
