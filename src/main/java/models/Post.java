package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer id;
    private User author;
    private LocalDateTime creation_dateTime;
    private String post_text;
    private List<Comment> comments;



}
