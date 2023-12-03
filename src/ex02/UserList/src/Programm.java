public class Programm {
    public static void main(String[] args) {
        User user1 = new User("Artem", 1000);
        User user2 = new User("Lana", 2000);
        User user3 = new User("Bob", 3000);
        User user4 = new User("Lena", 4000);
        User user5 = new User("Denis", 5000);
        User user6 = new User("Ded", 0);
        User user7 = new User("Vova", 2000);
        User user8 = new User("Mafia", 3000);
        User user9 = new User("Igor", 1000);
        User user10 = new User("Lana", 2000);
        User user11 = new User("Artem", 3000);
        User user12 = new User("Bob", 7777);
        UsersArrayList usersArrayList = new UsersArrayList();
        usersArrayList.addUser(user1);
        usersArrayList.addUser(user2);
        usersArrayList.addUser(user3);
        usersArrayList.addUser(user4);
        usersArrayList.addUser(user5);
        usersArrayList.addUser(user6);
        usersArrayList.addUser(user7);
        usersArrayList.addUser(user8);
        usersArrayList.addUser(user9);
        usersArrayList.addUser(user10);
        usersArrayList.addUser(user11);
        usersArrayList.addUser(user12);
        System.out.println(usersArrayList.toString());
        // System.out.println(usersArrayList.getUserById(100));
        // System.out.println(usersArrayList.getUserByIndex(100));
        System.out.println(usersArrayList.getUserById(1));
        System.out.println(usersArrayList.getUserById(2));
        System.out.println(usersArrayList.getUserById(11));
        System.out.println(usersArrayList.getUserByIndex(0));
        System.out.println(usersArrayList.getUserByIndex(2));
        System.out.println(usersArrayList.getUserByIndex(11));




    }


}
