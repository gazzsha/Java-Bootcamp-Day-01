public class User {
    private  int id;
    private String name;
    private long balance;
    public User(int id,String name,long balance) {
        this.id = id;
        this.name = name;
        if( balance > 0 ) this.balance = balance;
        else this.balance = 0;
    }
    public int getId() {
        return id;
    }
    public User(String name,long balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if( balance > 0 ) this.balance = balance;
        else this.balance = 0;
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

    @Override
    public String toString() {
        return "Id: " + id + "\n" + "Name: " + name + "\n" +"Balance: " + balance + "\n";
    }
}

