package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Date date_of_birth;



    public User(String firstname, String lastname, String email, String password, Date date_of_birth) {
        this.first_name = firstname;
        this.last_name = lastname;
        this.email = email;
        this.password = password;
        this.date_of_birth = date_of_birth;

    }


}
