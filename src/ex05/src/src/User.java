package src;

import java.util.UUID;

public class User {
    private int id;
    private String name;
    private long balance;

    private TransactionsLinkedList transactionsLinkedList;

    public User(int id, String name, long balance) {
        this.id = id;
        this.name = name;
        if (balance > 0) this.balance = balance;
        else this.balance = 0;
        this.transactionsLinkedList = new TransactionsLinkedList();
    }

    public int getId() {
        return id;
    }

    public User(String name, long balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance > 0) this.balance = balance;
        else this.balance = 0;
        this.transactionsLinkedList = new TransactionsLinkedList();
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        if (balance < 0) this.balance = 0;
        else this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTransaction(Transaction newTransaction) {
        transactionsLinkedList.addTransaction(newTransaction);
    }

    public void removeTransaction(UUID id) {
        transactionsLinkedList.removeTransactionByID(id);
    }

    Transaction getTransaction(UUID uuid) {
        return transactionsLinkedList.getTransactionByUUID(uuid);
    }

    public TransactionsLinkedList getTransactionsLinkedList() {
        return transactionsLinkedList;
    }

    @Override
    public String toString() {
        return "Id: " + id + " " + "Name: " + name;
    }
}

