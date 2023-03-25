package exception;

public class UserNotFoundException extends RuntimeException {
    @Override
    public String toString() {
        return "UserNotFoundException user is not available";
    }
}
