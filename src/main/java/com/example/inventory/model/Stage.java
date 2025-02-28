package com.example.inventory.model;

/**
 * Represents a stage in the dynamic programming problem.
 */

public class Stage {
        private int period;          // Time period (stage)
        private int inventoryLevel;  // Inventory level at the end of the period
        private double cost;         // Cost associated with this stage

        // Getters and Setters
        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public int getInventoryLevel() {
            return inventoryLevel;
        }

        public void setInventoryLevel(int inventoryLevel) {
            this.inventoryLevel = inventoryLevel;
        }

        public double getCost() {
            return cost;
        }
    public void setCost(double cost) {
        this.cost = cost;
    }

    // toString method
    @Override
    public String toString() {
        return "Stage{" +
                "period=" + period +
                ", inventoryLevel=" + inventoryLevel +
                ", cost=" + cost +
                '}';
    }

    // equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stage stage = (Stage) o;

        if (period != stage.period) return false;
        if (inventoryLevel != stage.inventoryLevel) return false;
        return Double.compare(stage.cost, cost) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = period;
        result = 31 * result + inventoryLevel;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    }
