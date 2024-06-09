package sales;

import Shop.ClothingItem;
import Shop.Inventory;
import cart.CartItem;
import cart.LinkedCart;

public class ShoppingRegister {

    private LinkedCart linkedCart;


    public ShoppingRegister() {
        linkedCart = new LinkedCart();
    }

    public void addToCart(Inventory inventory, String itemName, char size, int quantity) {
        int totalStock = inventory.checkStock(itemName, size);
        if (totalStock == 0) {
            System.out.println("No existe el item\n");
        } else {
            if (quantity > totalStock) throw new RuntimeException("Stock insuficiente");
            CartItem cartItem = extractItem(inventory, itemName, size, quantity);
            int index = linkedCart.find(itemName, size);
            if (index > -1) {
                CartItem cartItemFinded = linkedCart.find(index);
                cartItemFinded.setUnits(cartItemFinded.getUnits() + quantity);
            } else linkedCart.insert(linkedCart.size(), cartItem);
            System.out.println("Añadido correctamente\n");
        }
    }

    public void removeFromCart(Inventory inventory, String itemName, char size, int quantity) {
        int cartItemIndex = linkedCart.find(itemName, size);
        if (cartItemIndex < 0) {
            System.out.println("Error, el item no existe\n");
        } else {
            CartItem cartItem = linkedCart.find(cartItemIndex);
            if (quantity <= cartItem.getUnits()) {
                cartItem.setUnits(cartItem.getUnits() - quantity);
                for (int i = 0; i < quantity; i++) {
                    inventory.addItem(cartItem.getClothingItem());
                }
                if (cartItem.getUnits() == 0) {
                    linkedCart.remove(cartItemIndex);
                }
                System.out.println("Eliminado correctamente\n");
            } else {
                System.out.println("Error, cantidad insuficiente\n");
            }
        }
    }

    public void confirmCart(Inventory inventory) {
        double total = 0;
//        for (int i = 0; i < linkedCart.size(); i++) {
//            CartItem cartItem = linkedCart.find(i);
//            System.out.println(cartItem);
//            total += cartItem.getUnits() * cartItem.getClothingItem().getPrice();
//            for (int j = 0; j < cartItem.getUnits(); j++) {
//                inventory.addItem(cartItem.getClothingItem());
//                SalesRegister.processSale(inventory, cartItem.getClothingItem().getName(), cartItem.getClothingItem().getSize());
//            }
//        }
        int i = 0;
        while (!linkedCart.isEmpty()) {
            CartItem cartItem = linkedCart.find(i);
            System.out.println(cartItem);
            total += cartItem.getUnits() * cartItem.getClothingItem().getPrice();
            for (int j = 0; j < cartItem.getUnits(); j++) {
                inventory.addItem(cartItem.getClothingItem());
                SalesRegister.processSale(inventory, cartItem.getClothingItem().getName(), cartItem.getClothingItem().getSize());
            }
            linkedCart.remove(i);
            i++;
        }
        System.out.println("El coste total es de: " + total + "€\n");
//        for (int i = 0; i < linkedCart.size(); i++) {
//            linkedCart.remove(i);
//        }
    }


    public void showCart() {
        if (linkedCart.isEmpty()) {
            System.out.println("El carrito esta vacio\n");
        } else {
            for (int i = 0; i < linkedCart.size(); i++) {
                System.out.println(linkedCart.find(i));
            }
        }
    }

    private static CartItem extractItem(Inventory inventory, String itemName, char size, int quantity) {
        ClothingItem clothingItem = null;
        for (int i = 0; i < quantity; i++) {
            clothingItem = inventory.extractItem(itemName, size);
        }
        return new CartItem(clothingItem, quantity);
    }

}
