@Stateful
public class CartBean {

    private List<Product> cart = new ArrayList<>();

    public void addToCart(Product p) {
        cart.add(p);
    }

    public List<Product> getCart() {
        return cart;
    }

    public double getTotal() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }
}