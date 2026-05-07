package ex03;

import java.util.UUID;

// DEBITS == outgoing == -
// CREDITS == incoming == +

enum TransferCategory {
    INCOME, OUTCOME
}

class Transaction {
    private UUID Id;
    private User recipient;
    private User sender;
    private int amount;
    private TransferCategory category;

    public Transaction(User recipient, User sender, TransferCategory category, Integer amount) {
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        setAmount(amount);
    }

    public UUID getUuid() {
        return Id;
    }

    public void setUuid(UUID Id) {
        this.Id = Id;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int transferAmount) {
        if (category == TransferCategory.INCOME && transferAmount < 0) {
            System.out.println("Error: Credit amount must be positive");
            this.amount = 0;
        } else if (category == TransferCategory.OUTCOME && transferAmount > 0) {
            System.out.println("Error: Debit amount must be negative");
            this.amount = 0;
        } else {
            this.amount = transferAmount;
        }
    }

    public TransferCategory getCategory() {
        return category;
    }

    public void setCategory(TransferCategory transferCategory) {
        this.category = transferCategory;
    }

    @Override
    public String toString() {
        return (sender.getName() + " -> " + recipient.getName() + ", " +
                amount + ", " + category + "," + " transaction ID");
    }

}
