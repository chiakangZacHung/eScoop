package com.example.myapplication;

public class gelatoCustomerModel {

    private int id;
    private String name;
    private int quantity;


    //constructors


    public gelatoCustomerModel(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;

    }

    public gelatoCustomerModel() {
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +

                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
