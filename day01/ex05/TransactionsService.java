package ex05;

import java.util.UUID;

public class TransactionsService {

    private UsersList users;

    public void addUser(User user) {
        users.addUser(user);
    }

    public UsersList getUsers() {
        return this.users;
    }

    public int getUserBalance(User user) {
        User userData = users.getUserById(user.getId());
        return userData.getBalance();
    }

    // Performing a transfer transaction
    public void transferTransaction(int senderId, int recipientId, int transferAmount) {

        UUID sharedId = UUID.randomUUID();
        User sender = users.getUserById(senderId);
        User recipient = users.getUserById(recipientId);

        if (sender.getBalance() < transferAmount) {
            throw new IllegalTransactionException();
        }

        // Create the outcome transaction for the sender
        Transaction debit = new Transaction(sender, recipient,
                TransferCategory.OUTCOME, -transferAmount);
        debit.setUuid(sharedId);

        // Create the income transaction for recipient
        Transaction credit = new Transaction(sender, recipient,
                TransferCategory.OUTCOME, transferAmount);
        credit.setUuid(sharedId);

        // Add to user's transactions
        sender.getTransactionsLinkedList().AddTransaction(debit);
        recipient.getTransactionsLinkedList().AddTransaction(credit);

        // update balance
        sender.setBalence(sender.getBalance() - transferAmount);
        recipient.setBalence(sender.getBalance() + transferAmount);
    }

    // Retrieving transfers of a specific user
    Transaction[] retrieveUserTransaction(User user) {
        User userData = users.getUserById(user.getId());
        Transaction[] UsersTransactions = userData.getTransactionsLinkedList().toArray();

        return UsersTransactions;
    }

    // Removing a transaction by ID for a specific user
    void removeUserTransaction(UUID transactionId, int userId) {
        User userData = users.getUserById(userId);
        userData.transactionsLinkedList.removeTransactionById(transactionId);
    }

    // Check validity of transactions
    Transaction[] checkValidity() {
        TransactionsList allTransactions = new TransactionsLinkedList();
        TransactionsList unpairedTransactions = new TransactionsLinkedList();

        // get all transaction from every user into one list
        for (int i = 0; i < users.getUsersCount(); i++) {

            User userData = users.getUserByIndex(i);
            Transaction[] userTransactions = userData.getTransactionsLinkedList().toArray();

            for (Transaction t : userTransactions)
                allTransactions.AddTransaction(t);
        }

        Transaction[] total = allTransactions.toArray();

        for (int i = 0; i < total.length; i++) {
            int count = 0;
            for (int j = 0; j < total.length; j++) {
                if (total[j].getUuid().equals(total[i].getUuid()))
                    count++;
            }
            if (count == 1)
                unpairedTransactions.AddTransaction(total[i]);
        }
        return unpairedTransactions.toArray();
    }
}
