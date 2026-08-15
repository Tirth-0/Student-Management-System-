package StudentManagementsystem;

public abstract class User {

    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public abstract void displayRole();
}