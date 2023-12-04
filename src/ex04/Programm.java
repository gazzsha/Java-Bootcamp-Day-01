import src.TransactionsService;
import src.User;

import java.util.Arrays;
import java.util.UUID;

public class Programm {

    public static void main(String[] args) {
        User user1 = new User("Dima", 10_000);
        User user2 = new User("Diana", 500);

        TransactionsService transactionsService = new TransactionsService();

        transactionsService.addUser(user1);
        transactionsService.addUser(user2);
        System.out.println("Get balance User1: " + transactionsService.getBalance(user1.getId()));
        System.out.println("Get balance User2: " + transactionsService.getBalance(user2.getId()));
        System.out.println("User1 -> User2 - 5000");
        transactionsService.executeTransaction(user1.getId(),user2.getId(),5000);
        System.out.println("Get balance After transaction User1: " + transactionsService.getBalance(user1.getId()));
        System.out.println("Get balance After transaction User2: " + transactionsService.getBalance(user2.getId()));
        System.out.println("User1 -> User2 - 1000");
        transactionsService.executeTransaction(user1.getId(),user2.getId(),1000);
        System.out.println("Get balance After transaction User1: " + transactionsService.getBalance(user1.getId()));
        System.out.println("Get balance After transaction User2: " + transactionsService.getBalance(user2.getId()));
        System.out.println("User2 -> User1 - 2000");
        transactionsService.executeTransaction(user2.getId(),user1.getId(),2000);
        System.out.println("Get balance After transaction User1: " + transactionsService.getBalance(user1.getId()));
        System.out.println("Get balance After transaction User2: " + transactionsService.getBalance(user2.getId()));
        System.out.println("=========Transaction User1=========");
        System.out.println(Arrays.toString(transactionsService.getTransaction(user1.getId())));
        System.out.println("=========Transaction User2=========");
        System.out.println(Arrays.toString(transactionsService.getTransaction(user2.getId())));
        System.out.println("=========Transaction User1 After Removing=========");
        UUID idTransaction = user1.getTransactionsLinkedList().toArray()[0].getId();
        transactionsService.removeTransaction(user1.getId(),idTransaction);
        System.out.println(Arrays.toString(transactionsService.getTransaction(user1.getId())));
        System.out.println("=========UnpairedTransactions=========");
        System.out.println(Arrays.toString(transactionsService.getUnpairedTransactions()));
        System.out.println("=========Transfer uncorrected=========");
        transactionsService.executeTransaction(user1.getId(),user2.getId(),50000);
    }
}
