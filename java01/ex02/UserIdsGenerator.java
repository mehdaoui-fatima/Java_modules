package ex02;

//Singletons
public class UserIdsGenerator {
    private static int id = 0;
    // static field containing UserIdsGenerator class only instance
    private static UserIdsGenerator instance = null;

    // private constructor
    private UserIdsGenerator() {
    }

    // a static factory method for obtaining the instance
    public static UserIdsGenerator getInstance() {
        if (instance == null)
            instance = new UserIdsGenerator();
        return instance;
    }

    public int generateId() {
        return id++;
    }
}