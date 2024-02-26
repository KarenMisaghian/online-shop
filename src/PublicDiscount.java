public class PublicDiscount {
    private int percentage;
    private Product product;
    private String code;
    private Date expirationdate;

    PublicDiscount(int percentage, Product product, String code, Date expirationdate) {
        this.percentage = percentage;
        this.product = product;
        this.code = code;
        this.expirationdate = expirationdate;
    }

    public int getPercentage() {
        return percentage;
    }

    public Product getProduct() {
        return product;
    }

    public String getCode() {
        return code;
    }

    public Date getExpirationdate() {
        return expirationdate;
    }
}
