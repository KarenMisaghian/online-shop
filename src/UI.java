import java.util.Scanner;

public class UI {
    public static Scanner inputReader = new Scanner(System.in);

    // checked!
    public static int printWelcomeMenu() {
        System.out.println(
                "if you want to log in as an admin enter 1\nif you want to sign up as an admin enter 2\nif you want to log in as a user enter 3\nif you want to sign up as a user enter 4");
        int firstUserInput = inputReader.nextInt();
        inputReader.nextLine();
        return firstUserInput;
    }

    // checked!
    public static String[] loginAsUser() {
        System.out.println("please enter your username: ");
        String username = inputReader.nextLine();

        System.out.println("please enter your password: ");
        String password = inputReader.nextLine();

        String[] details = { username, password };
        return details;

    }

    // checked!
    public static String[] loginAsAdmin() {
        System.out.println("please enter your username: ");
        String username = inputReader.nextLine();

        System.out.println("please enter your password: ");
        String password = inputReader.nextLine();

        String[] details = { username, password };
        return details;
    }

    // checked!
    public static User signupAsUser() {
        System.out.println("please enter your username: ");
        String username = inputReader.nextLine();

        System.out.println("please enter your password: ");
        String password = inputReader.nextLine();

        System.out.println("please enter your name: ");
        String name = inputReader.nextLine();

        System.out.println("please enter your city: ");
        String city = inputReader.nextLine();

        System.out.println("please enter your address: ");
        String address = inputReader.nextLine();

        System.out.println("please enter your month of birth: ");
        int month = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter your day of birth: ");
        int day = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter your year: ");
        int year = inputReader.nextInt();
        inputReader.nextLine();

        Date date = new Date(month, year, day);

        if (date.dateValid()) {
            date.calculateValue();

            User user = new User(username, password, name, date, address, city);

            if (Data.getSelectedUser(username, password) == -1) {
                Data.setUsers(user);
                return user;
            } else {
                return null;
            }
        } else {
            System.out.println("date is not valid, try again...");
            return null;
        }

    }

    // checked!
    public static Admin signupAsAdmin() {
        System.out.println("please enter your username: ");
        String username = inputReader.nextLine();

        System.out.println("please enter your password: ");
        String password = inputReader.nextLine();

        Admin admin = new Admin(username, password);

        Data.setAdmins(admin);

        return admin;
    }

    // checked!
    public static int showMenuOfAdmin() {
        System.out.println(
                "if you want to:\n" + //
                        "add a new branch => 1\n" + //
                        "add a new category => 2\n" + //
                        "add a new product => 3\n" + //
                        "add a new announcement => 4\n" + //
                        "see all users => 5\n" + //
                        "see history of orders of a user => 6\n" + //
                        "apply discount => 7\n" + //
                        "sort users => 8\n" + //
                        "remove a comment of a product => 9\n" + //
                        "see products that did not sell much => 10\n" + //
                        "go back to main menu => 11");
        int answerOfAdmin = inputReader.nextInt();
        inputReader.nextLine();
        return answerOfAdmin;
    }

    public static Branch getNewBranch() {
        System.out.println("please enter the name of the branch: ");
        String name = inputReader.nextLine();

        System.out.println("please enter the city of the branch: ");
        String city = inputReader.nextLine();

        Branch branch = new Branch(name, city);
        return branch;
    }

    public static Category getCategory() {
        System.out.println("please enter the name of the category: ");
        String name = inputReader.nextLine();

        Category category = new Category(name);

        return category;
    }

    public static Product getProduct() {
        System.out.println("please enter the name of the product: ");
        String name = inputReader.nextLine();

        System.out.println("please enter the category of the product: ");
        String nameOfCategory = inputReader.nextLine();

        Category category = new Category(nameOfCategory);

        System.out.println("please enter the number of the product available: ");
        int numberAvailable = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the price of the product: ");
        int price = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the price of the normal shipping: ");
        int priceOfNormalShipping = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the price of the special shipping: ");
        int priceOfSpecialShipping = inputReader.nextInt();
        inputReader.nextLine();

        Product product = new Product(name, category, numberAvailable, price, priceOfNormalShipping,
                priceOfSpecialShipping);

        return product;
    }

    public static Announcement getAnnouncement() {
        System.out.println("please enter the title of the announcement: ");
        String title = inputReader.nextLine();

        System.out.println("please enter the description of the announcement: ");
        String description = inputReader.nextLine();

        Announcement announcement = new Announcement(title, description);

        return announcement;
    }

    public static int getUser() {
        System.out.println("please enter the id of the desired user: ");
        int answerOfUser = inputReader.nextInt();

        answerOfUser --;

        return answerOfUser;
    }

    public static int getTypeOfDiscount() {
        System.out.println(
                "if you want to add a public discount enter 1, else if you want to add a personal discount enter 2");
        int answerOfUser = inputReader.nextInt();

        return answerOfUser;
    }

    public static void getPublicDiscountDetails() {
        Data.printAllProducts();
        System.out.println("please enter the product id: ");
        int id = inputReader.nextInt() - 1;
        inputReader.nextLine();
        Product product = Data.getProduct(id);

        System.out.println("please enter the percentage of the discount (a number from 0 to 100): ");
        int percentage = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the code: ");
        String code = inputReader.nextLine();

        System.out.println("please enter day of expiration: ");
        int dayOfExpiration = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter month of expiration: ");
        int monthOfExpiration = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter year of expiration: ");
        int yearOfExpiration = inputReader.nextInt();
        inputReader.nextLine();

        Date expirationDate = new Date(monthOfExpiration, yearOfExpiration, dayOfExpiration);
        if (expirationDate.dateValid()) {
            PublicDiscount discount = new PublicDiscount(percentage, product, code, expirationDate);
            discount.getProduct().setPublicDiscount(discount);
        } else {
            System.out.println("invalid date, please try again...");
            getPublicDiscountDetails();
        }

        // product.setPublicDiscount(percentage);

        // product.applyPublicDiscount();

        // PublicDiscount discount = new PublicDiscount(percentage, product);
        // return discount;
    }

    public static PrivateDiscount getPrivateDiscountDetails() {
        Data.printAllUsers();
        System.out.println("please enter the user id: ");
        int id = inputReader.nextInt() - 1;
        inputReader.nextLine();
        User user = Data.getUser(id);

        System.out.println("please enter the amount of the discount: ");
        int amount = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the expiration day: ");
        int day = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the expiration month: ");
        int month = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the expiration year: ");
        int year = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the code: ");
        String code = inputReader.nextLine();

        Date date = new Date(month, year, day);

        if (date.dateValid()) {
            date.calculateValue();

            PrivateDiscount discount = new PrivateDiscount(user, amount, date, code);

            return discount;
        } else {
            System.out.println("date is not valid, please try again...");

            PrivateDiscount discount = UI.getPrivateDiscountDetails();

            return discount;
        }

    }

    public static Product selectProduct() {
        Data.printAllProducts();
        System.out.println("please enter the product id: ");
        int id = inputReader.nextInt() - 1;
        inputReader.nextLine();
        Product product = Data.getProduct(id);

        return product;
    }

    public static int getCommentId() {
        System.out.println("please enter the comment id: ");
        int id = inputReader.nextInt();
        inputReader.nextLine();

        id--;
        return id;
    }

    public static int showMenuOfUser() {
        System.out.println(
                "if you want to:\n" + //
                        "buy an item => 1\n" + //
                        "read announcements => 2\n" + //
                        "add comment on a product => 3\n" + //
                        "see history of orders => 4\n" + //
                        "go back to main menu => 5");
        int answerOfAdmin = inputReader.nextInt();
        inputReader.nextLine();
        return answerOfAdmin;
    }

    public static Branch selectBranch() {
        Data.printAllBranches();
        System.out.println("please enter the branch id: ");
        int id = inputReader.nextInt();
        inputReader.nextLine();

        id--;
        Branch branch = Data.getBranch(id);

        return branch;
    }

    public static Product collectMoreDetails(Product product, User user) {
        float totalCost = product.getPrice();

        System.out.println("please enter the destination city: ");
        String destination = inputReader.nextLine();
        product.setDestination(destination);

        System.out.println("the price of normal shipping is: " + product.getPriceOfNormalShipping()
                + " and price of premium shipping is: " + product.getPriceOfSpecialShipping()
                + "\nif you want normal shipping enter 1 else enter 2: ");
        int answerOfUser = inputReader.nextInt();
        inputReader.nextLine();

        if (answerOfUser == 1) {
            totalCost += product.getPriceOfNormalShipping();
        } else if (answerOfUser == 2) {
            totalCost += product.getPriceOfSpecialShipping();
        }

        System.out.println("please enter the day of order: ");
        int dayOfOrder = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the month of order: ");
        int monthOfOrder = inputReader.nextInt();
        inputReader.nextLine();

        System.out.println("please enter the year of order: ");
        int yearOfOrder = inputReader.nextInt();
        inputReader.nextLine();

        Date date = new Date(monthOfOrder, yearOfOrder, dayOfOrder);
        product.setDate(date);

        if (date.dateValid()) {
            date.calculateValue();

            // getting the private discount code:
            System.out.println("if you have a private discount code enter it, else write no: ");
            String privateDiscountCode = inputReader.nextLine();

            if (!privateDiscountCode.equals("no")) {
                product.setDiscountCode(privateDiscountCode);
            }

            int amountOfPrivateDiscount = user.validateDiscountCode(privateDiscountCode, date);

            totalCost -= amountOfPrivateDiscount;
            System.out.println("your total is: " + totalCost);

            // now we get the public discount code:
            System.out.println("if you have a public discount code enter it, else write no: ");
            String publicDiscountCode = inputReader.nextLine();

            if (!publicDiscountCode.equals("no")) {
                product.setDiscountCode(publicDiscountCode);

                boolean publicDiscountIsValid = product.validatePublicDiscountCode(publicDiscountCode, date);

                if (publicDiscountIsValid) {
                    // product.applyPublicDiscount();
                    totalCost *= (100 - product.getPublicDiscount().getPercentage());
                    totalCost /= 100;
                } else {
                    System.out.println("discount code is not valid!");
                }
            }

            System.out.println("your total is: " + totalCost);

            System.out.println("if you want to finalize your purchase, enter 1, else enter 2: ");
            int finalAnswerOfUser = inputReader.nextInt();
            inputReader.hasNextLine();

            if (finalAnswerOfUser == 1) {
                product.setFinalPrice(totalCost);
                return product;
            } else {
                return null;
            }
        } else {
            System.out.println("date is not valid, please try again...");

            Product newProduct = collectMoreDetails(product, user);

            return newProduct;
        }

    }

    public static Comment getComment(User user) {
        System.out.println("please enter your comment: ");
        String description = inputReader.nextLine();

        Comment comment = new Comment(user.getUserName(), description);
        return comment;
    }

    public static int getTypeOfSort() {
        System.out.println(
                "if you want to: \n" +
                        "sort users by most purchases => 1 \n" +
                        "sort users by latest purchase =>2 \n" +
                        "see all users that bought a certain product => 3 \n" +
                        "sort users by name => 4 \n" +
                        "sort users by birth date => 5");

        int answerOfUser = inputReader.nextInt();
        inputReader.nextLine();

        return answerOfUser;
    }
}
