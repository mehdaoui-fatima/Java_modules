package ex03;

import java.util.UUID;

public interface TransactionsList {

    // Add a transaction
    void AddTransaction(Transaction transaction);

    // Remove a transaction by ID
    void removeTransactionById(UUID ransactionId);

    // Transform into array
    Transaction[] toArray();

}
