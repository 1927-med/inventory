package com.example.inventory.service;

import com.example.inventory.model.Item;
import com.example.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//test
@Service
public class InventoryService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public void updateItem(Long id, Item item) {
        item.setId(id);
        itemRepository.save(item);
    }


    public double calculateTotalValue() {
        return itemRepository.findAll()
                .stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice())
                .sum();
    }


    public void showInventory() {
        itemRepository.findAll().forEach(System.out::println);
    }
}
