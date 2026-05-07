package ex02;

public class Program {

    public static void lisArray(UsersArrayList users) {

        for (int i = 0; i < users.getUsersCount(); i++)
            System.out.println(users.getUserByIndex(i));
    }

    public static void main(String[] args) {
        UsersArrayList users = new UsersArrayList();
        User mick = new User("Mick", 100);
        User john = new User("John", 100);

        System.out.println("-----Add users-----");
        users.addUser(mick);
        users.addUser(john);
        lisArray(users);

        System.out.println("-----Retrieve a user by ID-----");
        User user = users.getUserById(0);
        // User user_not_found = users.getUserById(20);

        System.out.println(user);
        // System.out.println(user_not_found);

        System.out.println("-----Retrieve a user by index-----");
        User user2 = users.getUserById(1);
        // User user_not_found2 = users.getUserById(20);

        System.out.println(user2);
        // System.out.println(user_not_found2);

        System.out.println("-----The total number of users-----");
        System.out.println(users.getUsersCount());

    }

}
