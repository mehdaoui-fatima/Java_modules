package ex00;

public class User {
    private int ID;
    private String name;
    private int balance;

    public User(int ID, String name, int balance) {
        this.ID = ID;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(int ID) {
        this.ID = ID;
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