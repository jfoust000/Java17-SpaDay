package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "Username is required.")
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters long.")
    private String userName;
    @Email(message = "Invalid email. Try again.")
    private String email;
    @NotBlank(message = "Password required.")
    @Min(6)
    private String password;
    @NotBlank(message = "Verify Password required.")
    @Min(6)
    private String verifyPassword;
    private boolean passwordsMatch;

    public User() {}

    public User(String userName, String email, String password, String verifyPassword ) {

        this.userName = userName;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordsMatch() {
        return passwordsMatch;
    }

    public void setPasswordsMatch(boolean passwordsMatch) {
        this.passwordsMatch = passwordsMatch;
    }



}
