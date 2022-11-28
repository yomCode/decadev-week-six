package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id;
    private String author;
    private Integer author_id;
    private Timestamp creation_dateTime;
    private String post_text;
    private List<Comment> comments;
    private List<Like> likes;



}
