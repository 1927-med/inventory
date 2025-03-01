package com.example.inventory;

import com.example.inventory.model.Item;
import com.example.inventory.model.Stage;
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
			inventoryService.addItem(new Item("Laptop", 5, 1200.00, 10, 50.0, 2.0));
			inventoryService.addItem(new Item("Mouse", 10, 25.00, 20, 30.0, 1.0));
			inventoryService.addItem(new Item("Keyboard", 7, 45.99, 15, 40.0, 1.5));
			inventoryService.addItem(new Item("laptop stand", 70, 45.99, 45, 40.0, 1.5));

			System.out.println("Total Inventory Value: $" + inventoryService.calculateTotalValue());
			System.out.println("Inventory Items:");
			inventoryService.showInventory();
		};
	}

	//Just for testing
	private static void testStageClass() {
		// Create a Stage object
		Stage stage = new Stage();
		stage.setPeriod(1);
		stage.setInventoryLevel(100);
		stage.setCost(50.0);

		// Print the Stage object
		System.out.println("Stage Test Output:");
		System.out.println(stage); // Should print: Stage{period=1, inventoryLevel=100, cost=50.0}
	}
}
