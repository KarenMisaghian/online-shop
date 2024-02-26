import java.util.ArrayList;

public class Product {
    private String name;
    private Category category;
    private int numberAvailable;//
    private int price;//
    private int priceOfNormalShipping;//
    private int priceOfSpecialShipping;//
    private Branch branch;//
    private String destination;//
    private Date date;//
    private String discount;//
    private PublicDiscount publicDiscount;
    private float finalPrice;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private ArrayList<User> buyers = new ArrayList<User>();

    public Product(String name, Category category, int numberAvailable, int price, int priceOfNormalShipping,
            int priceOfSpecialShipping) {
        this.name = name;
        this.category = category;
        this.numberAvailable = numberAvailable;
        this.price = price;
        this.priceOfNormalShipping = priceOfNormalShipping;
        this.priceOfSpecialShipping = priceOfSpecialShipping;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public int getPrice() {
        return price;
    }

    public int getPriceOfNormalShipping() {
        return priceOfNormalShipping;
    }

    public int getPriceOfSpecialShipping() {
        return priceOfSpecialShipping;
    }

    public Branch getBranch() {
        return branch;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDate() {
        return date;
    }

    public String getDiscount() {
        return discount;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public PublicDiscount getPublicDiscount() {
        return publicDiscount;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setPublicDiscount(PublicDiscount discount) {
        this.publicDiscount = discount;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDiscountCode(String code) {
        this.discount = code;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setBuyers(User user) {
        buyers.add(user);
    }

    public void setComments(Comment comment) {
        comments.add(comment);
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void removeComment(int idOfComment) {
        comments.remove(idOfComment);
    }

    // public void setBuyers(User user) {
    //     buyers.add(user);
    // }

    public void decreaseNumberAvailable(Product product) {
        numberAvailable--;
        if (numberAvailable <= 0) {
            int indexOfProduct = Data.getIndexOfProduct(product);
            Menu.deleteProduct(indexOfProduct);
        }
    }

    public void increaseNumberAvailable() {
        numberAvailable++;
    }

    public void printAllComments() {
        for (int i = 0; i < comments.size(); i++) {
            Comment comment = comments.get(i);
            int j = i + 1;
            System.out.println("comment id: " + j);
            System.out.println("publisher: " + comment.getUsername());
            System.out.println("comment description: " + comment.getDescription());
        }
    }

    public int getNumberOfBuyers() {
        return buyers.size();
    }

    public Product getMoreDetail(Product product, User user) {
        Product finalProduct = UI.collectMoreDetails(product, user);

        return finalProduct;
    }

    // public void applyPublicDiscount() {
    //     this.price *= (100 - this.publicDiscount.getPercentage());
    //     this.price /= 100;
    // }

    public void printAllBuyers() {
        for (int i = 0; i < this.buyers.size(); i++) {
            User user = this.buyers.get(i);
            System.out.println("name: " + user.getName());
            System.out.println("username: " + user.getUserName());
            System.out.println("city: " + user.getCity());
            System.out.println("address: " + user.getAddress());
            System.out.println("*******************************");
        }
    }

    public boolean validatePublicDiscountCode(String code, Date date) {
        if (code.equals(publicDiscount.getCode())) {
            publicDiscount.getExpirationdate().calculateValue();
            if (publicDiscount.getExpirationdate().getValue() >= date.getValue()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
