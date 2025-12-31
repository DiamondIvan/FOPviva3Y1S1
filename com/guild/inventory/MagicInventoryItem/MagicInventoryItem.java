package com.guild.inventory.MagicInventoryItem;

import java.util.List;
//List跟array差不多，只是list的话不用define size，可以随着多variable自己增加

public class MagicInventoryItem {

    // ----------------------------
    // Instance Variables
    // ----------------------------
    private String itemId; // Unique identifier
    private Integer stock; // Can be null

    // ----------------------------
    // Static Variables
    // ----------------------------
    private static final int MAX_STOCK = 1000;
    private static int totalItems = 0;

    // ----------------------------
    // No-Argument Constructor
    // ----------------------------
    public MagicInventoryItem() {
        this.itemId = "Unnamed Magic Item";
        this.stock = null;
        totalItems++;
    }

    // ----------------------------
    // Parameterized Constructor
    // ----------------------------
    public MagicInventoryItem(String itemId, int stock) {
        setItemId(itemId);

        if (stock > MAX_STOCK) {
            this.stock = MAX_STOCK;
        } else if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        } else {
            this.stock = stock;
        }

        totalItems++;
    }

    // ----------------------------
    // Getter and Setter for itemId
    // ----------------------------
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("Item ID cannot be empty");
        }
        this.itemId = itemId;
    }

    // ----------------------------
    // Getter and Setter for stock
    // ----------------------------
    public Integer getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0 || stock > MAX_STOCK) {
            throw new IllegalArgumentException(
                    "Stock must be between 0 and " + MAX_STOCK);
        }
        this.stock = stock;
    }

    // ----------------------------
    // Static Methods
    // ----------------------------
    public static int getTotalItems() {
        return totalItems;
    }

    public static Integer calculateTotalStock(List<MagicInventoryItem> items) {
        if (items == null || items.isEmpty()) {
            return null;
        }

        int totalStock = 0;

        for (int i = 0; i < items.size(); i++) {
            MagicInventoryItem item = items.get(i);

            if (item.getStock() != null) {
                totalStock += item.getStock();
            }
        }

        return totalStock;
    }
}