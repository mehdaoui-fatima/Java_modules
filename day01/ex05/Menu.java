package ex05;

import java.util.Scanner;

public class Menu {

    private TransactionsService service;
    Scanner scanner;

    public Menu() {
        this.service = new TransactionsService();
        this.scanner = new Scanner(System.in);
    }

    // Add a user
    public void AddUser() {
        boolean valid = false;
        String[] args;
        int balance = 0;
        String name = "";

        scanner.nextLine();
        // user shall be provided an ability to enter valid data.
        while (!valid) {
            System.out.println("Enter a user name and a balance");
            args = scanner.nextLine().split(" ");
            if (args.length != 2) {
                System.out.println("Wrong number of arguments");
                continue;
            }

            try {
                name = args[0];
                balance = Integer.parseInt(args[1]);
            } catch (NumberFormatException exception) {
                System.out.println("balance is not numeric");
                continue;
            }

            if (balance < 0) {
                System.out.println("balance should be a valid positive number");
                continue;
            }
            valid = true;
        }

        User user = new User(name, balance);
        service.addUser(user);
        System.out.printf("User with id = %d is added", user.getId());
    }

    // View user balances
    public void userBalance() {
        int id = 0;
        boolean valid = false;
        User user;

        scanner.nextLine();
        while (!valid) {
            System.out.println("Enter a user ID");
            String[] args = scanner.nextLine().split(" ");
            if (args.length != 1) {
                System.out.println("Wrong number of arguments");
                continue;
            }

            try {
                id = Integer.parseInt(args[0]);
            } catch (NumberFormatException exception) {
                System.out.println("user Id should be a valid positive number");
                continue;
            }

            try {
                user = service.getUsers().getUserById(id);
                System.out.printf("%s - %d", user.getName(), service.getUserBalance(user));
            } catch (UserNotFoundException userNotFoundException) {
                System.out.println(userNotFoundException.getMessage());
                continue;
            }
            valid = true;
        }
        return;
    }

    // Perform a transfer

    public void transferAmount() {
        String[] args;
        int senderId;
        int recipientId;
        int amount;
        boolean valid = false;

        scanner.nextLine();
        while (!valid) {
            System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
            args = scanner.nextLine().split(" ");

            if (args.length != 3) {
                System.out.println("Wrong number of arguments");
                continue;
            }
            try {
                senderId = Integer.parseInt(args[0]);
                recipientId = Integer.parseInt(args[1]);
                amount = Integer.parseInt(args[2]);

            } catch (NumberFormatException exception) {
                System.out.println("Enter a sender ID, a recipient ID, and a transfer amount must be numeric");
                continue;
            }

            if (senderId == recipientId) {
                System.out.println("Sender and recipient must be different");
                continue;
            }

            try {
                service.transferTransaction(senderId, recipientId, amount);

            } catch (IllegalTransactionException transactionException) {
                System.out.println(transactionException.getMessage());
                return;
            } catch (UserNotFoundException userException) {
                System.out.println(userException.getMessage());
                return;
            }

            valid = true;
        }
        System.out.println("The transfer is completed");
        return;
    }

    // View all transactions for a specific user
    public void userTransaction() {
        int id;
        String[] args;
        User user;
        boolean valid = false;
        Transaction[] transactions;

        scanner.nextLine();
        while (!valid) {
            System.out.println("Enter a user ID");
            args = scanner.nextLine().split(" ");
            try {
                id = Integer.parseInt(args[0]);
                user = service.getUsers().getUserById(id);
                transactions = service.retrieveUserTransaction(user);
                for (int t = 0; t < transactions.length; t++) {
                    System.out.format("To Mike(id = %d) %d with id = %s",
                            transactions[t].getRecipient().getId(),
                            transactions[t].getAmount(),
                            transactions[t].getUuid());
                }
            } catch (NumberFormatException exception) {
                System.out.println("user id must be numeric");
                continue;

            } catch (UserNotFoundException userException) {
                System.out.println(userException.getMessage());
                continue;
            }
            valid = true;
        }
    }

    // DEV - remove a transfer by ID
    public void removeTransferById() {

    }

}
