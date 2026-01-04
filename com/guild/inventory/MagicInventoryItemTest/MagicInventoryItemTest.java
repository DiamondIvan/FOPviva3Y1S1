package com.guild.inventory.MagicInventoryItemTest;

import com.guild.inventory.MagicInventoryItem.MagicInventoryItem;
import java.util.ArrayList;
import java.util.List;

public class MagicInventoryItemTest {

    public static void main(String[] args) {
        System.out.println("--- Magic Inventory Item Test Started ---");

        // ---------------------------------------------------------
        // Requirement 1: Create objects using both constructors
        // ---------------------------------------------------------
        System.out.println("\n1. Testing Object Creation:");

        // A. No-argument constructor
        MagicInventoryItem item1 = new MagicInventoryItem();
        System.out.println("Item 1 (No-arg): ID = " + item1.getItemId());

        // B. Parameterized constructor (Valid Stock)
        MagicInventoryItem item2 = new MagicInventoryItem("Potion-A", 500);
        System.out.println("Item 2 (Normal): ID = " + item2.getItemId() + " | Stock = " + item2.getStock());

        // C. Parameterized constructor (Testing Automatic Truncation)
        // Your friend's code automatically changes stock > 1000 to 1000 in the constructor
        System.out.println("Creating Item 3 with stock 1500 (Expect Truncation to 1000)...");
        MagicInventoryItem item3 = new MagicInventoryItem("Potion-B", 1500);
        
        if (item3.getStock() != null && item3.getStock() == 1000) {
            System.out.println("-> SUCCESS: Stock truncated to " + item3.getStock());
        } else {
            System.out.println("-> FAILED: Stock is " + item3.getStock());
        }

        // ---------------------------------------------------------
        // Requirement 2: Call setStock() with valid and invalid values
        // ---------------------------------------------------------
        System.out.println("\n2. Testing setStock() Validation:");

        // Valid set
        try {
            System.out.print("Setting valid stock (200)... ");
            item1.setStock(200);
            System.out.println("Success. New Stock: " + item1.getStock());
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        // Invalid: Negative Stock
        try {
            System.out.print("Attempting to set negative stock (-10)... ");
            item1.setStock(-10);
            System.out.println("Failed (Should have thrown exception).");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        // Invalid: Stock > 1000
        // Note: the Constructor truncates, but setStock THROWS an exception for > 1000.
        try {
            System.out.print("Attempting to set stock > 1000 (1200)... ");
            item1.setStock(1200); 
            System.out.println("Failed (Should have thrown exception).");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // Requirement 3: calculateTotalStock()
        // ---------------------------------------------------------
        System.out.println("\n3. Testing calculateTotalStock():");
        
        List<MagicInventoryItem> inventory = new ArrayList<>();

        // Case A: Empty List
        System.out.println("Total Stock (Empty List): " + MagicInventoryItem.calculateTotalStock(inventory));

        // Case B: Single Item
        inventory.add(item2); // Stock is 500
        System.out.println("Total Stock (1 Item): " + MagicInventoryItem.calculateTotalStock(inventory));

        // Case C: Multiple Items
        inventory.add(item1); // Stock is 200
        inventory.add(item3); // Stock is 1000
        // Total = 500 + 200 + 1000 = 1700
        System.out.println("Total Stock (3 Items): " + MagicInventoryItem.calculateTotalStock(inventory));

        // ---------------------------------------------------------
        // Requirement 4: Call getTotalItems()
        // ---------------------------------------------------------
        System.out.println("\n4. Testing Static Item Count:");
        // We created item1, item2, item3. Total should be 3.
        System.out.println("Total Items Created: " + MagicInventoryItem.getTotalItems());
    }
}