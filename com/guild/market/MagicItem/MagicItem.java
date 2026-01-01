package com.guild.market.MagicItem;

public class MagicItem {

    // Instance Variables
    private String name;
    private Double magicPrice; // Using Double wrapper to allow null

    // Static Variables
    private static final double MAGIC_TAX_RATE = 0.13;
    private static int itemCount = 0;

    // Constructors
    // No-argument constructor
    public MagicItem() {
        this.name = "Unnamed Magic Item";
        this.magicPrice = null;
        itemCount++;
    }

    // Parameterized constructor
    public MagicItem(String name, Double magicPrice) {
        this.name = name;
        // Check if price is negative before setting
        if (magicPrice != null && magicPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        this.magicPrice = magicPrice;
        itemCount++;
    }

    // Encapsulation Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMagicPrice() {
        return magicPrice;
    }

    public void setMagicPrice(double magicPrice) {
        if (magicPrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        this.magicPrice = magicPrice;
    }

    // Class Methods
    public static int getItemCount() {
        return itemCount;
    }

    public static double calculateTotal(double magicPrice, int quantity) {
        // Formula: magicPrice * quantity * (1 + MAGIC_TAX_RATE)
        return magicPrice * quantity * (1 + MAGIC_TAX_RATE);
    }
}