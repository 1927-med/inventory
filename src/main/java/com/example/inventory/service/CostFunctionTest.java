package com.example.inventory.service;

import java.util.Map;

public class CostFunctionTest {
    public static void main(String[] args) {
        double orderingCost = 50.0;
        double holdingCost = 2.0;
        CostFunction costFunction = new CostFunction(orderingCost, holdingCost);

        int z = 10; // Current inventory level
        int x = 20; // Order quantity
        int stage = 15; // Demand for the current stage
        Map<Integer, Double> nextStageCosts = Map.of(15, 100.0); // Example next stage costs

        double totalCost = costFunction.calculateCost(z, x, stage, nextStageCosts);
        System.out.println("Total Cost: " + totalCost);
    }
}
