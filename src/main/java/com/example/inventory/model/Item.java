package com.example.inventory.model;

import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    private double price;

    private int demand;          // Demand for the item in a given period
    private double orderingCost; // Fixed cost for placing an order
    private double holdingCost; // Cost of holding one unit of inventory

    public Item() {
    }

    public Item(String name, int quantity, double price, int demand, double orderingCost, double holdingCost) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.demand = demand;
        this.orderingCost = orderingCost;
        this.holdingCost = holdingCost;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public double getOrderingCost() {
        return orderingCost;
    }

    public void setOrderingCost(double orderingCost) {
        this.orderingCost = orderingCost;
    }

    public double getHoldingCost() {
        return holdingCost;
    }

    public void setHoldingCost(double holdingCost) {
        this.holdingCost = holdingCost;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", demand=" + demand +
                ", orderingCost=" + orderingCost +
                ", holdingCost=" + holdingCost +
                '}';
    }
}
