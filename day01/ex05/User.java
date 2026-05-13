package ex05;

public class User {
    private int id;
    private String name;
    private int balance;
    TransactionsLinkedList transactionsLinkedList;

    public User(String name, int balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        this.balance = balance;
        this.transactionsLinkedList = new TransactionsLinkedList();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTransactionsLinkedList(TransactionsLinkedList transactionsLinkedList) {
        this.transactionsLinkedList = transactionsLinkedList;
    }

    public TransactionsLinkedList getTransactionsLinkedList() {
        return transactionsLinkedList;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nname: " + getName()
                + "\nbalance: " + getBalance();
    }

}