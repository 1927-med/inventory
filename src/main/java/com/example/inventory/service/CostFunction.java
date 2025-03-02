package com.example.inventory.service;

import java.util.Map;

/**
 * Encapsulates the cost calculation logic for the dynamic ordering problem.
 */
public class CostFunction {

    private final double orderingCost; // Fixed cost for placing an order
    private final double holdingCost; // Cost of holding one unit of inventory

    public CostFunction(double orderingCost, double holdingCost) {
        this.orderingCost = orderingCost;
        this.holdingCost = holdingCost;
    }
    /**
     * Calculates the total cost for a given state and decision.
     *
     * @param z               Current inventory level.
     * @param x               Order quantity.
     * @param stage           Current stage (time period).
     * @param nextStageCosts  Optimal costs for the next stage.
     * @return The total cost for the current state and decision.
     */
    public double calculateCost(int z, int x, int stage, Map<Integer, Double> nextStageCosts) {
        // Calculate the inventory level after fulfilling demand
        int nextInventory = z + x - stage; // Assuming 'stage' represents demand for simplicity

        // Check for invalid state (inventory cannot be negative)
        if (nextInventory < 0) {
            return Double.MAX_VALUE; // Return a very high cost for invalid states
        }

        // Calculate ordering cost (fixed cost if x > 0)
        double totalCost = (x > 0) ? orderingCost : 0;

        // Add holding cost
        totalCost += holdingCost * nextInventory;

        // Add cost from the next stage (if not the last stage)
        if (nextStageCosts != null && !nextStageCosts.isEmpty()) {
            totalCost += nextStageCosts.getOrDefault(nextInventory, Double.MAX_VALUE);
        }

        return totalCost;
    }

}
