package ex05;

public class TransactionNode {
    private Transaction data;
    private TransactionNode previous;
    private TransactionNode next;

    public TransactionNode(Transaction data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction transaction) {
        this.data = transaction;
    }

    public TransactionNode getPrevious() {
        return previous;
    }

    public void setPrevious(TransactionNode node) {
        this.previous = node;
    }

    public TransactionNode getNext() {
        return next;
    }

    public void setNext(TransactionNode node) {
        this.next = node;
    }

}
