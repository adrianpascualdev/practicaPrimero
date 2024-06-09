package app;

import Shop.ClothingItem;
import Shop.Inventory;
import sales.SalesRegister;
import sales.ShoppingRegister;

import java.util.Scanner;

public class Main {

    public static final int PRIMERA_OPCION = 1;
    public static final int ULTIMA_OPCION = 9;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Inventory inventory = new Inventory(20);
        ShoppingRegister shoppingRegister = new ShoppingRegister();
        do {
            showMenu();
            int opcion = obtenerEntero(PRIMERA_OPCION, ULTIMA_OPCION);
            switch (opcion) {
                case 1:
                    addInventoryAnItem(inventory);
                    break;
                case 2:
                    showInventory(inventory);
                    break;
                case 3:
                    processVenta(inventory);
                    break;
                case 4:
                    showTotalVentas();
                    break;
                case 5:
                    addItemToCart(inventory, shoppingRegister);
                    break;
                case 6:
                    removeItemFromCart(inventory, shoppingRegister);
                    break;
                case 7:
                    shoppingRegister.confirmCart(inventory);
                    break;
                case 8:
                    shoppingRegister.showCart();
                    break;
                default:
                    System.exit(0);
            }
        }while (true);
    }

    private static void removeItemFromCart(Inventory inventory, ShoppingRegister shoppingRegister) {
        System.out.print("Introduce el nombre del item: ");
        String itemName = scanner.nextLine();
        System.out.print("Introduce la cantidad deseada: ");
        int quantity = obtenerEntero();
        System.out.print("Introduce la talla del item [S/L/M]: ");
        char size = obtenerChar();
        shoppingRegister.removeFromCart(inventory,itemName,size,quantity);
    }

    private static void addItemToCart(Inventory inventory, ShoppingRegister shoppingRegister) {
        System.out.print("Introduce el nombre del item: ");
        String itemName = scanner.nextLine();
        System.out.print("Introduce la cantidad deseada: ");
        int quantity = obtenerEntero();
        System.out.print("Introduce la talla del item [S/L/M]: ");
        char size = obtenerChar();
        shoppingRegister.addToCart(inventory,itemName,size,quantity);
    }

    private static void showTotalVentas() {
        System.out.println("Mostrando total de ventas...");
        System.out.println(SalesRegister.getBalance() + "\n");
    }

    private static void processVenta(Inventory inventory) {
        System.out.println("¿Que item deseas comprar?");
        System.out.println(inventory);
        System.out.println("Elige una opción entre 1 y " + inventory.getItemLength());
        int prenda = obtenerEntero(1, inventory.getItemLength());
        ClothingItem clothingItem = inventory.getItems()[prenda-1];
        SalesRegister.processSale(inventory, clothingItem.getName(), clothingItem.getSize());
        System.out.println("Item comprado correctamente \n");
    }

    private static void showInventory(Inventory inventory) {
        System.out.println("Mostrando inventario...");
        System.out.println(inventory + "\n");
    }

    private static void addInventoryAnItem(Inventory inventory) {
        System.out.println("Inserte los detalles de la prenda");
        System.out.print("Nombre: ");
        String nombre = obtenerString();
        System.out.print("Precio: ");
        double precio = obtenerDouble();
        System.out.print("Talla (S/M/L): ");
        char talla = obtenerChar();
        ClothingItem clothingItem = new ClothingItem(nombre, precio,talla);
        inventory.addItem(clothingItem);
        System.out.println("Se ha añadido el item correctamente \n");
    }

    private static void showMenu() {
        String menuOptions = """
                *** Bienvenido a Strafalarius ***
                Selecciona opción:
                1. Agregar nueva prenda al inventario
                2. Mostrar inventario
                3. Procesar venta
                4. Mostrar estadística de ventas
                5. Agregar prenda del carrito
                6. Eliminar prenda del carrito
                7. Confirmar carrito de compra
                8. Mostrar productos del carrito
                9. Salir
                Seleccione una opción (1-5):
                """;
        System.out.print(menuOptions);
    }

    private static int obtenerEntero(int rango1, int rango2) {
        do {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num <= rango2 && num >= rango1) {
                    scanner.nextLine();
                    return num;
                }else {
                    System.out.println("Error! Introduce un numero entero entre " + rango1 + " y " + rango2);
                }
            } else {
                scanner.next();
                System.out.println("Error! Introduce un numero entero");
            }
        } while (true);
    }

    private static int obtenerEntero() {
        do {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num > 0) {
                    scanner.nextLine();
                    return num;
                }else {
                    System.out.println("Error! Introduce un numero positivo");
                }
            } else {
                scanner.next();
                System.out.println("Error! Introduce un numero entero");
            }
        } while (true);
    }

    private static double obtenerDouble() {
        do {
            if (scanner.hasNextDouble()) {
                double num = scanner.nextDouble();
                if (num >= 0) {
                    scanner.nextLine();
                    return num;
                }else {
                    System.out.println("Error! Introduce un numero positivo");
                }
            } else {
                scanner.next();
                System.out.println("Error! Introduce un numero decimal");
            }
        } while (true);
    }

    private static char obtenerChar() {
        do {
            if (scanner.hasNext()) {
                char letter = scanner.next().charAt(0);
                if (letter == 'S' || letter == 'M' || letter == 'L' ) {
                    return letter;
                }else {
                    System.out.println("Error! Debes introducir una talla valida");
                }
            } else {
                scanner.next();
                System.out.println("Error! Introduce un caracter");
            }
        } while (true);
    }

    private static String obtenerString() {
        do {
            if (scanner.hasNext()) {
                String text = scanner.next();
                scanner.nextLine();
                return text;
            } else {
                scanner.next();
                System.out.println("Error! Introduce un caracter");
            }
        } while (true);
    }


}
