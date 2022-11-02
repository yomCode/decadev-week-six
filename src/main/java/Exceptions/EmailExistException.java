package Exceptions;

import java.sql.SQLException;

public class EmailExistException extends SQLException {
    public EmailExistException(String message) {
        super(message);
    }
}
