package com.example.boardcrud.dto.Responsse;

import com.example.boardcrud.Entity.Post;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private String userName;

    public PostResponse(Post post) { // dto 생성하는거임
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userName = post.getUserName();
    }
}

