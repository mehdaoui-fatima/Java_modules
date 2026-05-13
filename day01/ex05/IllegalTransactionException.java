package ex05;

public class IllegalTransactionException extends RuntimeException {

    @Override
    public String toString() {
        return "Error: Insufficient funds";
    }

}
