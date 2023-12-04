//package src;
//
//import java.util.Arrays;
//import java.util.UUID;
//
//public class Programm {
//    public static void main(String[] args) {
//        User user1 = new User("Artem", 1000);
//        User user2 = new User("Lana", 2000);
//
//        var id_1 = UUID.randomUUID();
//        var id_2 = UUID.randomUUID();
//        Transaction transactionUser1_1 = new Transaction(id_1, user1, user2, typeTransfer.DEBIT, 1000);
//        Transaction transactionUser2_1 = new Transaction(id_2, user2, user1, typeTransfer.CREDIT, -1000);
//        var id_3 = UUID.randomUUID();
//        var id_4 = UUID.randomUUID();
//        Transaction transactionUser2_2 = new Transaction(id_3, user2, user1, typeTransfer.DEBIT, 2000);
//        Transaction transactionUser1_2 = new Transaction(id_4, user1, user2, typeTransfer.CREDIT, -2000);
//        var id_5 = UUID.randomUUID();
//        var id_6 = UUID.randomUUID();
//        Transaction transactionUser1_3 = new Transaction(id_5, user1, user2, typeTransfer.DEBIT, 5000);
//        Transaction transactionUser2_3 = new Transaction(id_6, user2, user1, typeTransfer.CREDIT, -5000);
//        user1.addTransaction(transactionUser1_1);
//        user1.addTransaction(transactionUser2_1);
//        user1.addTransaction(transactionUser2_2);
//        user1.addTransaction(transactionUser1_2);
//        user1.addTransaction(transactionUser1_3);
//        user1.addTransaction(transactionUser2_3);
//
//        user2.addTransaction(transactionUser1_1);
//        user2.addTransaction(transactionUser2_1);
//        user2.addTransaction(transactionUser2_2);
//        user2.addTransaction(transactionUser1_2);
//        user2.addTransaction(transactionUser1_3);
//        user2.addTransaction(transactionUser2_3);
//
//        System.out.println("====TransactionList for User1====");
//        System.out.println(Arrays.toString(user1.getTransactionsLinkedList().toArray()));
//        System.out.println("====TransactionList for User2====");
//        System.out.println(Arrays.toString(user2.getTransactionsLinkedList().toArray()));
//        System.out.println("=========\nRemove all Transactions from User1...");
//        user1.removeTransaction(id_1);
//        user1.removeTransaction(id_2);
//        user1.removeTransaction(id_3);
//        user1.removeTransaction(id_4);
//        user1.removeTransaction(id_5);
//        user1.removeTransaction(id_6);
//        System.out.println("====TransactionList for User1====");
//        System.out.println("=========\nRemove non-existing ID...");
//        user1.removeTransaction(id_1);
////        user1.removeTransaction(id_2);
////        user1.removeTransaction(id_3);
////        user1.removeTransaction(id_4);
////        user1.removeTransaction(id_5);
////        user1.removeTransaction(id_6);
//    }
//
//
//}
