package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank(message = "Username is required!")
    @Size(max = 15, min = 5, message = "Username must contain between 5 to 15 characters.")
    private String username;

    @Email(message = "Invalid email. Try again.")
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 5, message = "Password must contain at least 6 characters.")
    private String password;

    @NotNull( message = "Passwords do not match")
    private String verifyPassword;

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    private void checkPassword() {
        if ( this.password != null && this.verifyPassword != null && !this.password.equals(this.verifyPassword) ) {
            this.verifyPassword = null;
        }
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        this.checkPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.checkPassword();
    }
}
