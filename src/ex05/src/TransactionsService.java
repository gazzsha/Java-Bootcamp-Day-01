package src;

import java.util.UUID;

public class TransactionsService {
    private UserList userList;

    public TransactionsService() {
        userList = new UsersArrayList();
    }

    public void addUser(User user) {
        userList.addUser(user);
    }


    public User getUser(int UserId) {
        return userList.getUserById(UserId);
    }

    public long getBalance(int id) {
        return userList.getUserById(id).getBalance();
    }

    public void executeTransaction(int senderId, int recipientId, long money) {
        if (userList.getUserById(senderId).getBalance() < money)
            throw new IllegalTransactionException("Not enough balance!");
        UUID transactionId = UUID.randomUUID();
        Transaction senderTransaction = new Transaction(transactionId, userList.getUserById(recipientId),
                userList.getUserById(senderId), typeTransfer.CREDIT, -money);
        Transaction recipientTransaction = new Transaction(transactionId, userList.getUserById(recipientId),
                userList.getUserById(senderId), typeTransfer.DEBIT, money);
        userList.getUserById(senderId).addTransaction(senderTransaction);
        userList.getUserById(recipientId).addTransaction(recipientTransaction);
        userList.getUserById(senderId).setBalance(userList.getUserById(senderId).getBalance() - money);
        userList.getUserById(recipientId).setBalance(userList.getUserById(recipientId).getBalance() + money);
    }

    public Transaction[] getTransaction(int userId) {
        return userList.getUserById(userId).getTransactionsLinkedList().toArray();
    }

    public void removeTransaction(int userId, UUID transactionId) {
        userList.getUserById(userId).removeTransaction(transactionId);
    }

    public Transaction[] getUnpairedTransactions() {
        TransactionsLinkedList unpairedTransaction = new TransactionsLinkedList();
        TransactionsLinkedList allTransaction = getAllTransactions();
        Transaction[] arrayAllTransaction = allTransaction.toArray();
        for (int i = 0; i != arrayAllTransaction.length; i++) {
            boolean pairFound = false;
            for (int j = 0; j != arrayAllTransaction.length; j++) {
                if (i != j && arrayAllTransaction[i].getId().equals(arrayAllTransaction[j].getId())) {
                    pairFound = true;
                    break;
                }
            }
            if (!pairFound) unpairedTransaction.addTransaction(arrayAllTransaction[i]);
        }
        return unpairedTransaction.toArray();
    }

    public TransactionsLinkedList getAllTransactions() {
        TransactionsLinkedList allTransaction = new TransactionsLinkedList();
        for (int i = 0; i != userList.getLenght(); i++) {
            for (Transaction transaction : userList.getUserByIndex(i).getTransactionsLinkedList().toArray()) {
                allTransaction.addTransaction(transaction);
            }
        }
        return allTransaction;
    }


}