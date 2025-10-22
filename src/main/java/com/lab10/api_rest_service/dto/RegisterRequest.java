package com.lab10.api_rest_service.dto;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;

    // Constructor vacío (obligatorio para Spring)
    public RegisterRequest() {
    }

    // Constructor completo (opcional)
    public RegisterRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters y setters
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
    }
}
