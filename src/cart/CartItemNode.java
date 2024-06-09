package cart;

public class CartItemNode {

    private CartItem cartItem;

    private CartItemNode next;

    public CartItemNode(CartItem cartItem) {
        this.cartItem = cartItem;
        this.next = null;
    }

    public CartItemNode(CartItem cartItem, CartItemNode next) {
        this.cartItem = cartItem;
        this.next = next;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public CartItemNode getNext() {
        return next;
    }

    public void setNext(CartItemNode next) {
        this.next = next;
    }

}
