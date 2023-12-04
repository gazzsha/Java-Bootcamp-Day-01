package src;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private TransactionsService transactionsService;
    private Scanner in;

    public Menu() {
        transactionsService = new TransactionsService();
        in = new Scanner(System.in);
    }

    public void menu() {
        showMenu();
        try {
            while (in.hasNext()) {
                switch (in.nextInt()) {
                    case 1:
                        addUserCatch();
                        break;
                    case 2:
                        getBalanceCatch();
                        break;
                    case 3:
                        executeTransferCatch();
                        break;
                    case 4:
                        viewAllTransactionsByUserCatch();
                        break;
                    case 5:
                        removeTransferCatch();
                        break;
                    case 6:
                        verifyTransfer();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
                showMenu();
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid argument");
            in.nextLine();
            menu();
        }
    }


    private void addUser() {
        System.out.println("Enter a user name and a balance");
        String name = in.next();
        long balance = in.nextInt();
        User newUser = new User(name, balance);
        transactionsService.addUser(newUser);
        System.out.println("User with id = " + newUser.getId() + " is added");
    }

    private void addUserCatch() {
        try {
            addUser();
        } catch (InputMismatchException exception) {
            in.nextLine();
            System.out.println(exception.toString());
            System.out.println("Try again?\n 1. YES \n 2. NO,GO TO MENU");
            int value = in.nextInt();
            if (value == 1) {
                addUser();
            }
        }
    }


    private void getBalance() throws UserNotFoundException {
        System.out.println("Enter a user ID");
        int userId = in.nextInt();
        long balanceUser = transactionsService.getBalance(userId);
        String nameUser = transactionsService.getUser(userId).getName();
        System.out.println(nameUser + " - " + balanceUser);
    }

    private void getBalanceCatch() {
        try {
            getBalance();
        } catch (InputMismatchException | UserNotFoundException exception) {
            if (exception instanceof InputMismatchException) in.nextLine();
            System.out.println(exception.toString());
            System.out.println("Try again?\n 1. YES \n 2. NO,GO TO MENU");
            int value = in.nextInt();
            if (value == 1) {
                getBalanceCatch();
            }
        }
    }

    private void executeTransfer() throws IllegalTransactionException, UserNotFoundException {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        int senderId = in.nextInt();
        int recipientId = in.nextInt();
        long amount = in.nextLong();
        transactionsService.executeTransaction(senderId, recipientId, amount);
        System.out.println("The transfer is completed");
    }

    private void executeTransferCatch() {
        try {
            executeTransfer();
        } catch (InputMismatchException | UserNotFoundException | IllegalTransactionException exception) {
            if (exception instanceof InputMismatchException) in.nextLine();
            System.out.println(exception.toString());
            System.out.println("Try again?\n 1. YES \n 2. NO,GO TO MENU");
            int value = in.nextInt();
            if (value == 1) {
                executeTransferCatch();
            }
        }
    }

    private void viewAllTransactionsByUser() throws UserNotFoundException {
        System.out.println("Enter a user ID");
        int userId = in.nextInt();
        Transaction[] transactions = transactionsService.getTransaction(userId);
        for (int i = 0; i != transactions.length; i++) {
            if (transactions[i].getTypeTransfer().equals(typeTransfer.CREDIT)) {
                System.out.println("To " + transactions[i].getRecipient().getName() + "(" +
                        transactions[i].getRecipient().getId() + ") " + transactions[i].getSumTransfer() +
                        " with id = " + transactions[i].getId());
            } else {
                System.out.println("FROM " + transactions[i].getSender().getName() + "(" +
                        transactions[i].getSender().getId() + ") " + transactions[i].getSumTransfer() +
                        " with id = " + transactions[i].getId());
            }
        }
    }

    private void viewAllTransactionsByUserCatch() {
        try {
            viewAllTransactionsByUser();
        } catch (InputMismatchException | UserNotFoundException exception) {
            if (exception instanceof InputMismatchException) in.nextLine();
            System.out.println(exception.toString());
            System.out.println("Try again?\n 1. YES \n 2. NO,GO TO MENU");
            int value = in.nextInt();
            if (value == 1) {
                viewAllTransactionsByUserCatch();
            }
        }
    }

    private void removeTransfer() throws UserNotFoundException, TransactionNotFoundException {
        System.out.println("Enter a user ID and a transfer ID");
        int userID = in.nextInt();
        String UUIDString = in.next();
        UUID uuidId = UUID.fromString(UUIDString);
        Transaction transaction = transactionsService.getUser(userID).getTransaction(uuidId);
        transactionsService.removeTransaction(userID, uuidId);
        if (transaction.getTypeTransfer().equals(typeTransfer.CREDIT)) {
            System.out.println("Transfer To " + transaction.getRecipient().getName() + "(id = " +
                    transaction.getRecipient().getId() + ") " + Math.abs(transaction.getSumTransfer()) + " removed");
        } else {
            System.out.println("Transfer From " + transaction.getSender().getName() + "(id = " +
                    transaction.getSender().getId() + ") " + Math.abs(transaction.getSumTransfer()) + " removed");
        }
    }

    private void removeTransferCatch() {
        try {
            removeTransfer();
        } catch (InputMismatchException | IllegalArgumentException | UserNotFoundException | TransactionNotFoundException exception) {
            if (exception instanceof InputMismatchException || exception instanceof IllegalArgumentException) in.nextLine();
            System.out.println(exception.toString());
            System.out.println("Try again?\n 1. YES \n 2. NO,GO TO MENU");
            int value = in.nextInt();
            if (value == 1) {
                removeTransferCatch();
            }
        }
    }

    private void verifyTransfer() {
        Transaction[] transaction = transactionsService.getUnpairedTransactions();
        System.out.println("Checks results:");
        if (transaction.length == 0) {
            System.out.println("All is good!");
        } else {
            for (int i = 0; i != transaction.length; i++) {
                if (transaction[i].getTypeTransfer().equals(typeTransfer.DEBIT)) {
                    System.out.format("%s(id = %d) has an unacknowledged transfer id = %s from %s(id = %d) for %d\n",
                            transaction[i].getRecipient().getName(), transaction[i].getRecipient().getId(),
                            transaction[i].getId().toString(), transaction[i].getSender().getName(), transaction[i].getSender().getId(),
                            Math.abs(transaction[i].getSumTransfer()));
                } else {
                    System.out.format("%s(id = %d) has an unacknowledged transfer id = %s to %s(id = %d) for %d\n",
                            transaction[i].getSender().getName(), transaction[i].getSender().getId(),
                            transaction[i].getId().toString(), transaction[i].getRecipient().getName(), transaction[i].getRecipient().getId(),
                            Math.abs(transaction[i].getSumTransfer()));
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("1. Add a user \n2. View user balances \n3. Perform a transfer \n4. View all transactions for a specific user\n5. DEV – remove a transfer by ID \n6. DEV – check transfer validity\n7. Finish execution");
    }
}