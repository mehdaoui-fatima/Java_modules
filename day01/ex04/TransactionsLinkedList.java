package ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    TransactionNode head;
    TransactionNode tail;
    int size = 0;

    public TransactionsLinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void AddTransaction(Transaction transaction) {
        TransactionNode node = new TransactionNode(transaction);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
    }

    @Override
    public void removeTransactionById(UUID transactionUuid) {

        TransactionNode current = head;

        while (current != null) {
            if (current.getData().getUuid().equals(transactionUuid)) {

                if (current.getPrevious() == null)
                    // Removing the head: the new head is the next node
                    head = current.getNext();
                else {
                    current.getPrevious().setNext(current.getNext());
                }

                if (current.getNext() == null)
                    tail = current.getPrevious(); // removing the tail
                else
                    current.getNext().setPrevious(current.getPrevious());

                // clean up the removed node
                current.setData(null);
                current.setNext(null);
                current.setPrevious(null);

                this.size--;
                return;
            }
            current = current.getNext();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[size];
        TransactionNode current = head;
        int i = 0;

        while (current != null) {
            transactions[i] = current.getData();
            current = current.getNext();
            i++;
        }

        return transactions;
    }

}
