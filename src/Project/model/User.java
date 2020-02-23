package Project.model;

public class User extends MainModel {
    private Long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(Long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ", " + userName + ", " + password + ", " + country + ", " + userType;
    }
}