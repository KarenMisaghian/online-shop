public class PrivateDiscount {
    private User user;
    private int amount;
    private Date expireDate;
    private String code;

    public PrivateDiscount(User user, int amount, Date expireDate, String code) {
        this.amount = amount;
        this.expireDate = expireDate;
        this.user = user;
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public int getAmount() {
        return amount;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public String getCode() {
        return code;
    }
}
