package authentication;

public class Authentication {

    public void authenticate(String username, String password) {
        // authentication logic
        // For simplicity, let's assume authentication is successful if username and password are not empty
        if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
            System.out.println("Authentication successful for username: " + username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
