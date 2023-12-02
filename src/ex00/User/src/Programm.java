import java.util.UUID;

public class Programm {
    public static void main(String[] argc) {
        User userFirst = new User(1,"Artem",1000);
        System.out.println(userFirst.toString());
        System.out.println("Balance from get : " + userFirst.getBalance());
        System.out.println("Set Balance negative value(-2000)");
        userFirst.setBalance(-2000);
        System.out.println("Balance from get : " + userFirst.getBalance());
        System.out.println("Set Balance positive value(1000)");
        userFirst.setBalance(1000);
        System.out.println("Balance from get : " + userFirst.getBalance());
        User userSecond = new User(2,"Motya",0);
        System.out.println(userSecond.toString());
        User userThird = new User(3,"Aydar",-300);
        System.out.println(userThird.toString());
        User userFourth = new User(4,"Dima",10000);
        System.out.println(userThird.toString());
        Transaction transactionFisrt = new Transaction(UUID.randomUUID(),userFirst,userSecond,typeTransfer.DEBIT,1000);
        System.out.println(transactionFisrt);
        Transaction transactionSecond = new Transaction(UUID.randomUUID(),userThird,userFourth,typeTransfer.CREDIT,-2000);
        System.out.println(transactionSecond);
        Transaction transactionTrird = new Transaction(UUID.randomUUID(),userThird,userSecond,typeTransfer.CREDIT,+2000);
        System.out.println(transactionTrird);
        Transaction transactionFourth = new Transaction(UUID.randomUUID(),userThird,userFirst,typeTransfer.DEBIT,-1000);
        System.out.println(transactionFourth);

    }

}
