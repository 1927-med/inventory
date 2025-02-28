package com.example.inventory.service;

import java.util.HashMap;
import java.util.Map;

public class OrderingProblemSolver {
    private final double orderingCost;
    private final double holdingCost;
    private final int[] demands;

    public OrderingProblemSolver(double orderingCost, double holdingCost, int[] demands) {
        this.orderingCost = orderingCost;
        this.holdingCost = holdingCost;
        this.demands = demands;
    }

    /**
     * Solves the dynamic ordering problem using backward recursion.
     *
     * @return A map of inventory levels to their minimal costs.
     */
    public Map<Integer, Double> solve() {
        int stages = demands.length;
        Map<Integer, Double> optimalCosts = new HashMap<>();

        // Start from the last stage and move backward
        for (int i = stages - 1; i >= 0; i--) {
            Map<Integer, Double> currentStageCosts = new HashMap<>();

            // Iterate over possible inventory levels
            for (int z = 0; z <= 100; z++) { // Assuming max inventory is 100
                double minCost = Double.MAX_VALUE;

                // Iterate over possible order quantities
                for (int x = 0; x <= 100; x++) { // Assuming max order is 100
                    double cost = calculateCost(z, x, i, optimalCosts);
                    if (cost < minCost) {
                        minCost = cost;
                    }
                }

                currentStageCosts.put(z, minCost);
            }

            optimalCosts = currentStageCosts;
        }

        return optimalCosts;
    }

    /**
     * Calculates the cost for a given state and decision.
     *
     * @param z               Current inventory level.
     * @param x               Order quantity.
     * @param stage           Current stage (time period).
     * @param nextStageCosts  Optimal costs for the next stage.
     * @return The total cost for the current state and decision.
     */
    private double calculateCost(int z, int x, int stage, Map<Integer, Double> nextStageCosts) {
        int demand = demands[stage];
        int nextInventory = z + x - demand;

        // Invalid state (inventory cannot be negative)
        if (nextInventory < 0) {
            return Double.MAX_VALUE;
        }
        // Calculate ordering cost (fixed cost if x > 0)
        double cost = (x > 0) ? orderingCost : 0;

        // Add holding cost
        cost += holdingCost * nextInventory;

        // Add cost from the next stage (if not the last stage)
        if (stage < demands.length - 1) {
            cost += nextStageCosts.getOrDefault(nextInventory, Double.MAX_VALUE);
        }

        return cost;
    }
}
