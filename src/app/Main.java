package app;

import Shop.ClothingItem;
import Shop.Inventory;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(7);
        ClothingItem item2 = new ClothingItem("Pantalon", 25.99, 'M');
        ClothingItem item3 = new ClothingItem("Camiseta", 80, 'L');

        ClothingItem item4 = new ClothingItem("Calcetin", 90, 'S');
        ClothingItem item5 = new ClothingItem("Pantalon", 25.99, 'M');
        ClothingItem item6 = new ClothingItem("Camisa", 25.99, 'M');

        inventory.addItem(item2);
        inventory.addItem(item3);
        inventory.addItem(item4);
        inventory.addItem(item5);
        inventory.addItem(item6);
        inventory.addItem(new ClothingItem("Cami",12,'L'));
        inventory.addItem(new ClothingItem("Camisetilla",12,'S'));
        inventory.addItem(new ClothingItem("ErRober",12,'S'));
        inventory.addItem(new ClothingItem("ElCumpleañista",12,'S'));

        // Aqui se ejecuta tal..
        
        ClothingItem itemExtracted = inventory.extractItem("Calcetin", 'S');
        System.out.println(itemExtracted);
        System.out.println("Stock = " + inventory.checkStock("Calcetin",'S'));
        inventory.removeItem(item2.getName(),item2.getSize());
        System.out.print(inventory);
    }

}
