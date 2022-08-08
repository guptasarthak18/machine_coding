package splitwise.model;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final long mobileNumber;

    public User(String id, String name, String email, long mobileNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }
}
