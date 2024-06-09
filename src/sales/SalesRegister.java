package sales;

import Shop.ClothingItem;
import Shop.Inventory;

public class SalesRegister {

    private static long totalSalesCount;

    private static double totalSalesAmount;

    public static ClothingItem processSale(Inventory inventory, String name, char size) {
        int totalItems = inventory.checkStock(name, size);
        if (totalItems == 0) {
            System.out.println("No hay produtos");
            System.exit(0);
            return null;
        }

        ClothingItem item = inventory.extractItem(name,size);
        totalSalesCount++;
        totalSalesAmount += item.getPrice();
        return item;
    }

    public static String getBalance() {
        return "Total sales count: " + getTotalSalesCount() + ", total sales amount: " + getTotalSalesAmount();
    }

    public static void resetTotalSalesCount() {
        totalSalesCount = 0;
    }

    public static void resetTotalSalesAmount() {
        totalSalesAmount = 0;
    }

    public static long getTotalSalesCount() {
        return totalSalesCount;
    }

    public static double getTotalSalesAmount() {
        return totalSalesAmount;
    }

}
