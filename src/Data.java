import java.util.ArrayList;

public class Data {
    private static ArrayList<Admin> admins = new ArrayList<Admin>();
    private static ArrayList<User> users = new ArrayList<User>();
    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<Announcement> announcements = new ArrayList<Announcement>();
    private static ArrayList<Branch> branches = new ArrayList<Branch>();
    private static ArrayList<Category> categories = new ArrayList<Category>();

    public User user;
    public Admin admin;
    public boolean isAdmin;

    public Data(Admin admin, boolean isAdmin) {
        this.admin = admin;
        this.isAdmin = isAdmin;
    }

    public Data(User user, boolean isAdmin) {
        this.user = user;
        this.isAdmin = isAdmin;
    }

    public static void setUsers(User user) {
        users.add(user);
    }

    public static void removeUser(int index) {
        users.remove(users.get(index));
    }

    public static void setAdmins(Admin admin) {
        admins.add(admin);
    }

    public static void setProduct(Product product) {
        products.add(product);
    }

    public static void removeProduct(int indexOfProduct) {
        products.remove(indexOfProduct);
    }

    public static void setAnnouncements(Announcement announcement) {
        announcements.add(announcement);
    }

    public static void removeAnnouncements(int i) {
        announcements.remove(i);
    }

    public static void setCategory(Category category) {
        categories.add(category);
    }

    public static int getIndexOfProduct(Product product) {
        int index = products.indexOf(product);
        return index;
    }

    public static void printAllAnnouncements() {
        for (int i = 0; i < announcements.size(); i++) {
            System.out.println("title:" + announcements.get(i).getTitle());
            System.out.println(announcements.get(i).getDescription());
            System.out.println("******************");
        }
    }

    public static int getSelectedUser(String username, String password) {
        int indexOfUser = -1;

        for (int i = 0; i < users.size(); i++) {
            User tempUser = users.get(i);
            if (tempUser.getUserName().equals(username) && tempUser.getPassword().equals(password)) {
                indexOfUser = i;
            }
        }

        return indexOfUser;
    }

    public static void setBranch(Branch branch) {
        branches.add(branch);
    }

    public static User getUser(int i) {
        return users.get(i);
    }

    public static Admin getAdmin(int i) {
        return admins.get(i);
    }

    public static Product getProduct(int i) {
        return products.get(i);
    }

    public static Branch getBranch(int i) {
        return branches.get(i);
    }

    public static int getSelectedAdmin(String username, String password) {
        int indexOfAdmin = -1;

        for (int i = 0; i < admins.size(); i++) {
            Admin tempAdmin = admins.get(i);
            if (tempAdmin.getUserName().equals(username) && tempAdmin.getPassWord().equals(password)) {
                indexOfAdmin = i;
            }
        }

        return indexOfAdmin;
    }

    public static void printAllUsers() {
        for (int i = 0; i < users.size(); i++) {
            int j = i + 1;
            System.out.println("id: " + j);
            System.out.println("username" + users.get(i).getUserName());
            System.out.println("name: " + users.get(i).getName());
            System.out.println("address: " + users.get(i).getAddress());
            System.out.print("birth date: ");
            users.get(i).getBirthDate().printDate();
            // System.out.println("city: " + users.get(i).city);
            System.out.println("******************");
        }
    }

    public static void printHistoryOfOrders(int i) {
        User user = users.get(i);
        printAllOrders(user);

    }

    public static void printAllOrders(User user) {
        ArrayList<Product> productsOfUser = user.getProduct();
        for (int j = 0; j < productsOfUser.size(); j++) {
            System.out.println("id:" + j);
            System.out.println("name: " + productsOfUser.get(j).getName());
            System.out.println("price: " + productsOfUser.get(j).getPrice());
        }
    }

    public static void printAllProducts() {
        for (int i = 0; i < products.size(); i++) {
            int j = i + 1;
            System.out.println("id: " + j);
            System.out.println("name: " + products.get(i).getName());
            System.out.println("price: " + products.get(i).getPrice());
            System.out.println("number available: " + products.get(i).getNumberAvailable());
            System.out.println("----------------------------------------");
            System.out.println("comments: ");
            for (int k = 0; k < products.get(i).getComments().size(); k++) {
                System.out.println("username:");
                System.out.println(products.get(i).getComments().get(k).getUsername());
                System.out.println("description: ");
                System.out.println(products.get(i).getComments().get(k).getDescription());
                System.out.println("...................");
            }
            System.out.println("***********************************");
        }
    }

    public static void printLeastSoldProducts() {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            int numberSold = product.getNumberOfBuyers();
            if (numberSold <= 2) {
                System.out.println("name: " + products.get(i).getName());
                System.out.println("price: " + products.get(i).getPrice());
            }
        }
    }

    public static void printAllBranches() {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            int j = i + 1;
            System.out.println("branch id: " + j);
            System.out.println("name: " + branch.getName());
            System.out.println("branch city: " + branch.getCity());
        }
    }

    // public static User[] createArrayOfUsers() {
    // User[] arrayOfUsers = new User[users.size()];

    // for (int i = 0; i < users.size(); i++) {
    // User user = users.get(i);
    // arrayOfUsers[i] = user;
    // }

    // return arrayOfUsers;
    // }

    public static void sortUsersByNumberOfPurchases() {
        ArrayList<User> sortedUsers = new ArrayList<User>();
        int[][] tempArray = new int[2][users.size()];
        System.out.println(users.size());

        for (int i = 0; i < users.size(); i++) {
            tempArray[i][1] = users.get(i).getNumberOfOrders();
            System.out.println(users.get(i).getNumberOfOrders());
            tempArray[i][0] = i;
        }

        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (tempArray[i][1] < tempArray[j][1]) {
                    int[] temporaryArray = new int[2];

                    System.out.println("entered the loop!");

                    temporaryArray[1] = tempArray[i][1];
                    temporaryArray[0] = tempArray[i][0];

                    tempArray[i][1] = tempArray[j][1];
                    tempArray[i][0] = tempArray[j][0];

                    tempArray[j][1] = temporaryArray[1];
                    tempArray[j][0] = temporaryArray[0];
                }
            }
        }

        for (int i = 0; i < users.size(); i++) {
            sortedUsers.add(users.get(tempArray[i][0]));
        }

        for (int i = 0; i < sortedUsers.size(); i++) {
            int j = i + 1;
            System.out.println("id: " + j);
            System.out.println("username" + sortedUsers.get(i).getUserName());
            System.out.println("name: " + sortedUsers.get(i).getName());
            System.out.println("address: " + sortedUsers.get(i).getAddress());
            System.out.print("birth date: ");
            sortedUsers.get(i).getBirthDate().printDate();
            // System.out.println("city: " + users.get(i).city);
            System.out.println("******************");
        }
    }

    public static void sortUsersByBirthDay() {
        ArrayList<User> sortedUsers = new ArrayList<User>();
        int[][] tempArray = new int[2][users.size()];

        for (int i = 0; i < users.size(); i++) {
            tempArray[i][1] = users.get(i).getBirthDate().getValue();
            tempArray[i][0] = i;
        }

        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (tempArray[i][1] < tempArray[j][1]) {
                    int[] temporaryArray = new int[2];

                    temporaryArray[1] = tempArray[i][1];
                    temporaryArray[0] = tempArray[i][0];

                    tempArray[i][1] = tempArray[j][1];
                    tempArray[i][0] = tempArray[j][0];

                    tempArray[j][1] = temporaryArray[1];
                    tempArray[j][0] = temporaryArray[0];
                }
            }
        }

        for (int i = 0; i < users.size(); i++) {
            sortedUsers.add(users.get(tempArray[i][0]));
        }

        for (int i = 0; i < sortedUsers.size(); i++) {
            int j = i + 1;
            System.out.println("id: " + j);
            System.out.println("username" + sortedUsers.get(i).getUserName());
            System.out.println("name: " + sortedUsers.get(i).getName());
            System.out.println("address: " + sortedUsers.get(i).getAddress());
            System.out.print("birth date: ");
            sortedUsers.get(i).getBirthDate().printDate();
            // System.out.println("city: " + users.get(i).city);
            System.out.println("******************");
        }
    }

    public static void sortUsersByName() {
        ArrayList<User> sortedUsers = new ArrayList<User>();
        String[] names = new String[users.size()];

        for (int i = 0; i < users.size(); i++) {
            names[i] = users.get(i).getName();
        }

        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    String tempName = "";

                    tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                }
            }
        }

        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < users.size(); j++) {
                if (users.get(j).getName().equals(names[i])) {
                    sortedUsers.add(users.get(j));
                }
            }

        }

        for (int i = 0; i < sortedUsers.size(); i++) {
            int j = i + 1;
            System.out.println("id: " + j);
            System.out.println("username" + sortedUsers.get(i).getUserName());
            System.out.println("name: " + sortedUsers.get(i).getUserName());
            System.out.println("address: " + sortedUsers.get(i).getAddress());
            System.out.print("birth date: ");
            sortedUsers.get(i).getBirthDate().printDate();
            // System.out.println("city: " + users.get(i).city);
            System.out.println("******************");
        }
    }

    public static void sortUsersByLatestPurchase() {
        ArrayList<User> sortedUsers = new ArrayList<User>();
        int[][] tempArray = new int[2][users.size()];

        for (int i = 0; i < users.size(); i++) {
            tempArray[i][1] = users.get(i).getLatestPurchase();
            tempArray[i][0] = i;
        }

        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (tempArray[i][1] > tempArray[j][1]) {
                    int[] temporaryArray = new int[2];

                    temporaryArray[1] = tempArray[i][1];
                    temporaryArray[0] = tempArray[i][0];

                    tempArray[i][1] = tempArray[j][1];
                    tempArray[i][0] = tempArray[j][0];

                    tempArray[j][1] = temporaryArray[1];
                    tempArray[j][0] = temporaryArray[0];
                }
            }
        }

        for (int i = 0; i < users.size(); i++) {
            sortedUsers.add(users.get(tempArray[i][0]));
        }

        for (int i = 0; i < sortedUsers.size(); i++) {
            int j = i + 1;
            System.out.println("id: " + j);
            System.out.println("username" + sortedUsers.get(i).getUserName());
            System.out.println("name: " + sortedUsers.get(i).getName());
            System.out.println("address: " + sortedUsers.get(i).getAddress());
            System.out.print("birth date: ");
            sortedUsers.get(i).getBirthDate().printDate();
            // System.out.println("city: " + users.get(i).city);
            System.out.println("******************");
        }
    }

    public static void changeTwoUsers(User user1, User user2) {
        User tempUser = user1;
        user1 = user2;
        user2 = tempUser;
    }
}
