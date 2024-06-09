package Shop;

public class ClothingItem {

    private String name;

    private double price;

    private char size;

    public ClothingItem(String name, double price, char size) {
        this.name = name;
        this.price = price;
        this.setSize(size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        if (size != 'S' && size != 'M' && size != 'L') {
            this.size = 'S';
        } else  {
            this.size = size;
        }
    }

    @Override
    public String toString() {
        return String.format("Nombre de la prenda %s, con precio de %.2f€ y con talla %s única", name, price, size);
    }

}
