package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {

    private Integer id;
    private Integer user_id;
    private Integer post_id;
    private String liker;
    private Date likeDate;
}
