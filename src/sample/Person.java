package sample;

public abstract class Person {
    private String name;
    private String username;
    private String password;
    private String Email;
    private String phoneNumber;
    private String address;
    Person()
    {
        username="Abc";
    }
    Person(String username, String password, String name, String Email, String phoneNumber, String address) // Creating Account
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.Email = Email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public abstract Boolean Login(String username,String password);
}

