package src;
public class UserIdsGenerator {
    private int generateId = 0;
    private static UserIdsGenerator instance = null;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        generateId++;
        return generateId;
    }

    @Override
    public String toString() {
        return "generateId: " + generateId + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserIdsGenerator that = (UserIdsGenerator) o;

        return generateId == that.generateId;
    }

    @Override
    public int hashCode() {
        return generateId;
    }
}