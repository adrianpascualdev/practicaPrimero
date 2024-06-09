package cart;

public class LinkedCart {

    private CartItemNode first;

    private int size;

    public LinkedCart() {
        this.first = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int find(String itemName, char size) {
        if (first == null) return -1;
        int index = 0;
        CartItemNode aux = first;
        while (aux != null) {
            if (aux.getCartItem().getClothingItem().getName().equalsIgnoreCase(itemName) &&
                    aux.getCartItem().getClothingItem().getSize() == size) return index;
            aux = aux.getNext();
            index++;
        }
        return -1;
    }

    public CartItem find(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("Fuera de rango");
        CartItemNode aux = first;
        for (int i = 0; i < index; i++) {
            aux = aux.getNext();
        }
        return aux.getCartItem();
    }

    public int size() {
        return this.size;
    }

    public void insert(int index, CartItem item) {
        if (index < 0 || index > size) throw new RuntimeException("Indice incorrecto");
        if (size == 0) this.first = new CartItemNode(item);
        else {
            CartItemNode aux = first;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            //CartItemNode following = aux.getNext();
            aux.setNext(new CartItemNode(item, aux.getNext()));
        }
        this.size++;
    }

    public CartItem remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fuera de rango");
        CartItemNode removedNode = first;
        if (index == 0) first = first.getNext();
        else {
            CartItemNode aux = first;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.getNext();
            }
            removedNode = aux.getNext();
            aux.setNext(removedNode.getNext());
        }
        this.size--;
        return removedNode.getCartItem();
    }

}
