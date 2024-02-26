public class Admin {
    private String userName;
    private String passWord;

    public Admin (String username, String password) {
        this.userName = username;
        this.passWord = password;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getUserName() {
        return userName;
    }
    
}
