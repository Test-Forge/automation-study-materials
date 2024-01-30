package steps;

import lombok.Data;

@Data
public class User {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    String phone;

    public User(Long id, String firstName, String lastName, String email, String password, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}

