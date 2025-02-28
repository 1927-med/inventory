package com.example.inventory.controller;

import com.example.inventory.model.Item;
import com.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/items")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        return new ResponseEntity<>(inventoryService.addItem(item), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = inventoryService.getItemById(id);
        return item != null ? new ResponseEntity<>(item, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateItem(@PathVariable Long id, @RequestBody Item item) {
        inventoryService.updateItem(id, item);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        inventoryService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Solves the dynamic ordering problem.
     *
     * @param orderingCost Fixed cost for placing an order.
     * @param holdingCost  Cost of holding one unit of inventory.
     * @param demands      Array of demands for each time period.
     * @return A map of inventory levels to their minimal costs.
     */
    @PostMapping("/solve")
    public Map<Integer, Double> solveOrderingProblem(
            @RequestParam double orderingCost,
            @RequestParam double holdingCost,
            @RequestBody int[] demands) {
        return inventoryService.solveOrderingProblem(orderingCost, holdingCost, demands);
    }
}
