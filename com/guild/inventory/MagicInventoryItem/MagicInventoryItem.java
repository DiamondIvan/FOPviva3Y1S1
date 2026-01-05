package com.guild.inventory.MagicInventoryItem;

// Necessary import for List
import java.util.*;

public class MagicInventoryItem {
    // Instance Variables
    private String itemId;
    private Integer stock;
    // Static Variables
    private static final int MAX_STOCK = 1000;
    private static int totalItems = 0;

    // Constructors
    public MagicInventoryItem() {
        this.itemId = "Unnamed Magic Item";
        this.stock = null;
        totalItems++;
    }

    // Parameterized Constructor
    public MagicInventoryItem(String itemId, int stock) {
        this.itemId = itemId;

        if (stock > MAX_STOCK) {
            this.stock = MAX_STOCK;
        } else if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        } else {
            this.stock = stock;
        }

        totalItems++;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("Item ID cannot be empty");
        }
        this.itemId = itemId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        // Enforce maximum stock limit
        this.stock = Math.min(stock, MAX_STOCK);
    }

    public static int getTotalItems() {
        return totalItems;
    }

    public static Integer calculateTotalStock(List<MagicInventoryItem> items) {
        if (items == null || items.isEmpty()) {
            return 0;
        }

        int totalStock = 0;

        // Calculate total stock
        for (int i = 0; i < items.size(); i++) {
            MagicInventoryItem item = items.get(i);

            if (item.getStock() != null) {
                totalStock += item.getStock();
            }
        }

        return totalStock;
    }
}