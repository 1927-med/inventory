package com.example.inventory;

import com.example.inventory.model.Item;
import com.example.inventory.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	CommandLineRunner run(InventoryService inventoryService) {
		return args -> {
			inventoryService.addItem(new Item("Laptop", 5, 1200.00));
			inventoryService.addItem(new Item("Mouse", 10, 25.00));
			inventoryService.addItem(new Item("Keyboard", 7, 45.99));

			System.out.println("Total Inventory Value: $" + inventoryService.calculateTotalValue());
			System.out.println("Inventory Items:");
			inventoryService.showInventory();
		};
	}
}
