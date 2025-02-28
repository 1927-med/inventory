package com.example.inventory.model;

public class StageTest {
    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.setPeriod(1);
        stage.setInventoryLevel(100);
        stage.setCost(50.0);

        System.out.println(stage); // Should print: Stage{period=1, inventoryLevel=100, cost=50.0}
    }
}
