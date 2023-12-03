package src;
public interface UserList {
    public void addUser(User newUser);

    User getUserById(int id);

    User getUserByIndex(int index);

    int getLenght();
}