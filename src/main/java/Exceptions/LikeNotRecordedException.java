package Exceptions;

import java.sql.SQLException;

public class LikeNotRecordedException extends SQLException {
    public LikeNotRecordedException(String reason) {
        super(reason);
    }
}
