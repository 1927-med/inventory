package com.example.inventory.controller;

import com.example.inventory.model.Item;
import com.example.inventory.service.InventoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final InventoryService inventoryService;

    public HomeController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Fetch all items from the service
        List<Item> items = inventoryService.getAllItems();

        // Add the items to the model
        model.addAttribute("items", items);

        // Return the Thymeleaf template name (index.html)
        return "index";
    }
}
