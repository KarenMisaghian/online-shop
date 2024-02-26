import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Product> products = new ArrayList<Product>();

    public Category(String name) {
        this.name = name;
    }

    public void setProducts (Product product){
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
    
}
