package ex00;

public class Program {
    public static void main(String[] args) {

        User Mick = new User(1, "Mick", 500);
        User John = new User(12, "John", 400);

        Transaction outgoing = new Transaction(Mick, John, TransferCategory.OUTCOME, -100);
        Transaction incoming = new Transaction(Mick, John, TransferCategory.INCOME, 100);

        System.out.println(Mick);
        System.out.println(John);

        System.out.println(outgoing);
        System.out.println(incoming);

    }
}