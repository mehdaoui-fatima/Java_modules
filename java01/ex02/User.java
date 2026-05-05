package ex02;

public class User {
    private int id;
    private String name;
    private int balance;

    public User(String name, int balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setName(String name) {
        this.name = name;

    }

    public void setBalence(int balance) {
        if (balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nname: " + getName()
                + "\nbalance: " + getBalance();
    }

}