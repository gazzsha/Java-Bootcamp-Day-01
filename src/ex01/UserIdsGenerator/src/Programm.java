public class Programm {
    public static void main(String[] argc) {
        User user1 = new User("Artem",1000);
        System.out.println(user1);
        System.out.println(UserIdsGenerator.getInstance().toString());
        User user2 = new User("Matya",2000);
        System.out.println(user2);
        System.out.println(UserIdsGenerator.getInstance().toString());
        User user3 = new User("Lena",3000);
        System.out.println(user3);
        System.out.println(UserIdsGenerator.getInstance().toString());
        UserIdsGenerator userIdsGenerator = UserIdsGenerator.getInstance();
        System.out.println("Create \"new object\" userIdsGenerator");
        System.out.println(userIdsGenerator.toString());
        User user4 = new User("Lena",-3000);
        System.out.println(user4);
        System.out.println(userIdsGenerator.toString());
        System.out.println("Equals objects singlton\n" + userIdsGenerator.equals(UserIdsGenerator.getInstance()));
    }
}
