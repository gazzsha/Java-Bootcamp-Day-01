package src;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException(String string) {
        super(string);
    }
}
