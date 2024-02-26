import java.util.ArrayList;

public class User {
    private String userName;
    private String passWord;
    private String name;
    private Date birthDate;
    private String address;
    private String city;
    private ArrayList<Product> products = new ArrayList<Product>();
    private ArrayList<PrivateDiscount> discounts = new ArrayList<PrivateDiscount>();

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return passWord;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public User(String userName, String passWord, String name, Date birthDate, String address, String city) {
        this.userName = userName;
        this.passWord = passWord;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }

    public void printHistoryOfOrders() {
        for (int i = 0; i < products.size(); i++) {
            int n = i + 1;
            System.out.println("id of ticket: " + n);
            System.out.println("name of the product: " + products.get(i).getName());
            System.out.println("price: " + products.get(i).getPrice());
            System.out.println("quantity of the product: " + products.get(i).getNumberAvailable());
            System.out.println("category: " + products.get(i).getCategory());
            System.out.println("**********");
        }
    }

    public void printAllDiscounts() {
        for (int i = 0; i < discounts.size(); i++) {
            int n = i + 1;
            System.out.println("id of discount: " + n);
            System.out.println("amount of discount: " + discounts.get(i).getAmount());
            System.out.println("expiration date: ");
            discounts.get(i).getExpireDate().printDate();
            System.out.println("**********");
        }
    }

    // private int calculateTotalCost(){
    // int totalCost = 0;
    // for (int i = 0; i < products.size(); i++){
    // totalCost += products.get(i).price;
    // }
    // return totalCost;
    // }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public void setProducts(Product product) {
        products.add(product);
    }

    public int getNumberOfOrders() {
        int numberOfProducts = products.size();
        return numberOfProducts;
    }

    public void removeOrder(int i) {
        products.remove(i);
    }

    public void setOrder(Product trip) {
        products.add(trip);
    }

    public void setDiscount(PrivateDiscount discount) {
        discounts.add(discount);
    }

    public void removeDiscount(int i) {
        discounts.remove(i);
    }

    public ArrayList<Product> getProduct() {
        return products;
    }

    public int validateDiscountCode(String testCode, Date date) {
        int amount = 0;
        for (int i = 0; i < discounts.size(); i++) {
            PrivateDiscount discount = discounts.get(i);
            if (testCode.equals(discount.getCode()) && discount.getExpireDate().getValue() >= date.getValue()) {
                amount = discounts.get(i).getAmount();
            }
        }
        return amount;
    }

    public int getLatestPurchase() {
        int biggestValue = 0;
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).getDate().getValue() > biggestValue) {
                biggestValue = this.products.get(i).getDate().getValue();
            }
        }
        return biggestValue;
    }
}
