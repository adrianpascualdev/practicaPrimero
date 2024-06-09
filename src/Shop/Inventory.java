package Shop;

public class Inventory {

    private static int MAX_SIZE = 7;

    private ClothingItem[] items;

    private int itemLength;

    public Inventory(int size) {
        MAX_SIZE = size;
        this.items = new ClothingItem[MAX_SIZE];
        this.itemLength = 0;
    }

    public void addItem(ClothingItem item) {
        if (itemLength < MAX_SIZE) {
            items[itemLength] = item;
            itemLength++;
        }
    }

    public int checkStock(String itemName, char size) {
        int totalItems = 0;
        for (int i = 0; i < itemLength; i++) {
            if (items[i].getName().equalsIgnoreCase(itemName) && items[i].getSize() == size) {
                totalItems++;
            }
        }
        return totalItems;
    }

    public void removeItem(String itemName, char size) {
        int totalStock = checkStock(itemName, size);
        if (totalStock == 0) {
            return;
        }
        for (int i = 0; i < this.itemLength; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getName().equalsIgnoreCase(itemName) && this.items[i].getSize() == size) {
                    this.items[i] = null;
                }
            }
            if (items[i] == null) {
                this.items[i] = this.items[i + 1];
                this.items[i + 1] = null;
            }
        }
        this.itemLength--;
    }

    public ClothingItem extractItem(String itemName, char size) {
        for (int i = 0; i < itemLength; i++) {
            if (items[i].getName().equalsIgnoreCase(itemName) && items[i].getSize() == size) {
                ClothingItem foundedItem = items[i];
                this.removeItem(itemName, size);
                return foundedItem;
            }
        }
        return null;
    }

    public static int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public static void setMAX_SIZE(int maxSize) {
        MAX_SIZE = maxSize;
    }

    public ClothingItem[] getItems() {
        return items;
    }

    public void setItems(ClothingItem[] items) {
        this.items = items;
    }

    public int getItemLength() {
        return itemLength;
    }

    public void setItemLength(int itemLength) {
        this.itemLength = itemLength;
    }

    @Override
    public String toString() {
        String table = String.format("""
                Inventario: => itemLength=%d, MAX_SIZE=%s
                Nombre\t\t\t\tPrecio\t\t\t  Talla\t\t
                -------------------------------------------
                """, itemLength, MAX_SIZE);
        for (ClothingItem item : items) {
            if (item != null) {
                table = table.concat(String.format("%-20s%-20.2f%-20c%n",item.getName(),item.getPrice(),item.getSize()));
            }
        }
        return table;
    }


    public int getItemCount() {
        return itemLength;
    }

}
