package cart;

import Shop.ClothingItem;

public class CartItem {

    private ClothingItem clothingItem;

    private int units;

    public CartItem(ClothingItem clothingItem, int units) {
        this.clothingItem = clothingItem;
        this.units = units;
    }

    public ClothingItem getClothingItem() {
        return clothingItem;
    }

    public void setClothingItem(ClothingItem clothingItem) {
        this.clothingItem = clothingItem;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "clothingItem=" + clothingItem +
                ", units=" + units +
                '}';
    }

}
