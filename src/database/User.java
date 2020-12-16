package database;

public class User {
    private final int id;
    private final int admin;
    private final String username;

    User(int id, int admin, String username) {
        this.id = id;
        this.admin = admin;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public int getAdmin() {
        return admin;
    }

    public String getUsername() {
        return username;
    }
}
