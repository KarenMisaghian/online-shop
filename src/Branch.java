import java.util.ArrayList;

public class Branch {
    private String name;
    private String city;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Branch(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setProducts(Product product) {
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
