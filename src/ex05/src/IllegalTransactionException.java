package src;

public class IllegalTransactionException extends RuntimeException {
    IllegalTransactionException(String string) {
        super(string);
    }
}
