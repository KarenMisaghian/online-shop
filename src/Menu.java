public class Menu {
    public static void showMenu() {
        int userAnswer = UI.printWelcomeMenu();

        if (userAnswer == 1) {
            String[] user = UI.loginAsAdmin();
            if (Data.getSelectedAdmin(user[0], user[1]) != -1) {
                Data.setAdmins(Data.getAdmin(Data.getSelectedAdmin(user[0], user[1])));
                showMenuOfAdmin();
            } else {
                System.out.println("wrong input please try again");
                showMenu();
            }
        }

        else if (userAnswer == 3) {
            String[] user = UI.loginAsUser();
            if (Data.getSelectedUser(user[0], user[1]) != -1) {
                Data.setUsers(Data.getUser(Data.getSelectedUser(user[0], user[1])));
                User selectedUser = Data.getUser(Data.getSelectedUser(user[0], user[1]));
                showMenuOfUser(selectedUser);
            } else {
                System.out.println("wrong input please try again");
                showMenu();
            }
        }

        else if (userAnswer == 2) {
            Admin admin = UI.signupAsAdmin();
            if (admin != null) {
                showMenuOfAdmin();
            } else {
                System.out.println("the details are used before, please try again...");
                showMenu();
            }
        }

        else {
            User user = UI.signupAsUser();
            if (user != null) {
                showMenuOfUser(user);
            } else {
                System.out.println("the details are used before, please try again...");
                showMenu();
            }
        }
    }

    public static void showMenuOfAdmin() {
        int answerOfAdmin = UI.showMenuOfAdmin();
        switch (answerOfAdmin) {
            case 1:
                addNewBranch();//
                break;
            case 2:
                addNewCategory();//
                break;
            case 3:
                addNewProduct();//
                break;
            case 4:
                addNewAnnouncement();//
                break;
            case 5:
                Data.printAllUsers();//
                showMenuOfAdmin();
                break;
            case 6:
                printHistoryOfUser();//
                break;
            case 7:
                applyDiscount();//
                break;
            case 8:
                sortUsers();//
                break;
            case 9:
                removeComment();//
                break;
            case 10:
                seeLeastSoldProducts();//
                break;
            case 11:
                showMenu();//
                break;
        }
    }

    public static void addNewBranch() {
        Branch branch = UI.getNewBranch();
        Data.setBranch(branch);
        System.out.println("branch " + branch.getName() + " added");
        showMenuOfAdmin();
    }

    public static void addNewCategory() {
        Category category = UI.getCategory();
        Data.setCategory(category);
        System.out.println("category " + category.getName() + " added");
        showMenuOfAdmin();
        ;
    }

    public static void addNewProduct() {
        Product product = UI.getProduct();
        Data.setProduct(product);
        System.out.println("product " + product.getName() + " added");
        showMenuOfAdmin();
    }

    public static void addNewAnnouncement() {
        Announcement announcement = UI.getAnnouncement();
        Data.setAnnouncements(announcement);
        System.out.println("the announcement " + announcement.getTitle() + " added");
        showMenuOfAdmin();
    }

    public static void printHistoryOfUser() {
        Data.printAllUsers();
        int idOfUser = UI.getUser();
        Data.printHistoryOfOrders(idOfUser);
        showMenuOfAdmin();
    }

    public static void applyDiscount() {
        int typeOfDiscount = UI.getTypeOfDiscount();
        switch (typeOfDiscount) {
            case 1:
                applyPublicDiscount();
                break;
            case 2:
                applyPrivateDiscount();
                break;

        }
        showMenuOfAdmin();
    }

    public static void applyPublicDiscount() {
        UI.getPublicDiscountDetails();

        // discount.product.publicDiscount = discount.percentage;

    }

    public static void applyPrivateDiscount() {
        PrivateDiscount discount = UI.getPrivateDiscountDetails();

        discount.getUser().setDiscount(discount);
    }

    public static void sortUsers() {
        int typeOfSort = UI.getTypeOfSort();

        switch (typeOfSort) {
            case 1:
                sortByMostPurchases();
                break;
            case 2:
                sortByLatestPurchase();
                break;
            case 3:
                printAllBuyersOfAProduct();
                break;
            case 4:
                sortByName();
                break;
            case 5:
                sortByBirthDay();
                break;
        }
    }

    public static void removeComment() {
        Product product = UI.selectProduct();

        product.printAllComments();

        int commentId = UI.getCommentId();

        product.removeComment(commentId);

        showMenuOfAdmin();
    }

    public static void seeLeastSoldProducts() {
        Data.printLeastSoldProducts();
        showMenuOfAdmin();
    }

    public static void showMenuOfUser(User user) {
        int answerOfUser = UI.showMenuOfUser();
        switch (answerOfUser) {
            case 1:
                buyProduct(user);
                break;
            case 2:
                Data.printAllAnnouncements();//
                showMenuOfUser(user);
                break;
            case 3:
                addComment(user);//
                break;
            case 4:
                Data.printAllOrders(user);//
                showMenuOfUser(user);
                break;
            case 5:
                showMenu();
                break;
        }
    }

    public static void buyProduct(User user) {
        Product product = UI.selectProduct();
        Branch branch = UI.selectBranch();
        product.getMoreDetail(product, user);
        branch.setProducts(product);
        user.setProducts(product);
        product.decreaseNumberAvailable(product);
        product.setBuyers(user);
        showMenuOfUser(user);
    }

    public static void addComment(User user) {
        Product product = UI.selectProduct();

        Comment comment = UI.getComment(user);

        product.setComments(comment);
        showMenuOfUser(user);
    }

    public static void sortByMostPurchases() {
        Data.sortUsersByNumberOfPurchases();
        showMenuOfAdmin();
    }

    public static void sortByBirthDay() {
        Data.sortUsersByBirthDay();
        showMenuOfAdmin();
    }

    public static void printAllBuyersOfAProduct() {
        Product product = UI.selectProduct();
        product.printAllBuyers();
        showMenuOfAdmin();
    }

    public static void sortByName() {
        Data.sortUsersByName();
        showMenuOfAdmin();
    }

    public static void sortByLatestPurchase() {
        Data.sortUsersByLatestPurchase();
        showMenuOfAdmin();
    }

    public static void deleteProduct(int indexOfProduct) {
        Data.removeProduct(indexOfProduct);
    }
}
