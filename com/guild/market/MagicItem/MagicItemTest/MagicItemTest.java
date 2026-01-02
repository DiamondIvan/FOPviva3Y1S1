package com.guild.market.MagicItem.MagicItemTest;
import com.guild.market.MagicItem.MagicItem;
public class MagicItemTest {

    public static void main(String[] args) {

        // Create MagicItem objects using no-argument constructor
        MagicItem item1 = new MagicItem();
        MagicItem item2 = new MagicItem();

        // Create MagicItem objects using parameterized constructor
        MagicItem item3 = new MagicItem("Healing Potion(Silver)", 50.0);
        MagicItem item4 = new MagicItem("Flying Boots(Gold)", 120.0);
        MagicItem item6= new MagicItem("Enchanted Invisibility Scrolls(Platinum)", 688.0);
        // Display initial values
        System.out.println("Item1 Name: " + item1.getName());
        System.out.println();
        System.out.println("Item1 Price: " + item1.getMagicPrice());
        System.out.println();
        System.out.println("Item3 Name: " + item3.getName());
        System.out.println();
        System.out.println("Item3 Price: " + item3.getMagicPrice());
        System.out.println();
        System.out.println("Item6 Name: " + item6.getName());
        System.out.println();
        System.out.println("Item6 Price: " + item6.getMagicPrice());
        System.out.println();
        // Test setMagicPrice with valid value
        item1.setMagicPrice(30.0);
        System.out.println("Item1 Price is: " + item1.getMagicPrice());
        //Test setName
        item2.setName("Mystic Wand(???)(Broken elder wand)");
        System.out.println("Item2 Name is: " + item2.getName());
      
        
        // Test setMagicPrice with invalid value
        try {
            item2.setMagicPrice(-15.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Test parameterized constructor with invalid price
        try {
            MagicItem item5 = new MagicItem("Cursed Scroll(Diamond) (by Ivan)", -40.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in constructor: " + e.getMessage());
        }

        // Test calculateTotal()
        double totalPrice1 = MagicItem.calculateTotal(50.0, 3);
        double totalPrice2 = MagicItem.calculateTotal(120.0, 2);
        double totalPrice3 = MagicItem.calculateTotal(688.0, 1);
        
        System.out.println("Total price for 3 Healing Potions(Silver) (with tax): " + totalPrice1);
        System.out.println("Total price for 2 Flying Boots(Gold) (with tax): " + totalPrice2);
        System.out.println("Total price for 1 Enchanted Invisibility Scrolls(Platinum) (with tax): " + totalPrice3);
        // Test getItemCount()
        System.out.println("Total Magic Items created: " + MagicItem.getItemCount());
    }
}
