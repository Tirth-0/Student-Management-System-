package StudentManagementsystem;

public abstract class User {

    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    // Every user should have a role
    public abstract void displayRole();
}