import java.util.Arrays;

public class UsersArrayList implements UserList {
    private User[] arrayUser;
    private int size;

    private int capacity;

    public UsersArrayList() {
        size = 0;
        capacity = 10;
        arrayUser = new User[capacity];
    }

    private void reserve() {
        if (size == capacity) {
            capacity *= 2;
            User[] newArrayUser = new User[capacity];
            for (int i = 0; i != size; i++) {
                newArrayUser[i] = arrayUser[i];
            }
            arrayUser = newArrayUser;
        }
    }

    @Override
    public void addUser(User newUser) {
        reserve();
        arrayUser[size] = newUser;
        size++;
    }

    @Override
    public User getUserById(int id) {
        for (int i = 0; i != size; i++) {
            if (arrayUser[i].getId() == id) return arrayUser[i];
        }
        throw new UserNotFoundException("Oops! User not found!");
    }

    @Override
    public User getUserByIndex(int index) {
        if (index <= size) return arrayUser[index];
        throw new UserNotFoundException("Oops! User not found!");
    }

    @Override
    public int getLenght() {
        return size;
    }

    @Override
    public String toString() {
        return "UsersArrayList{" +
                "arrayUser=\n" + Arrays.toString(arrayUser) +
                ", size=" + size +
                '}';
    }

}
