package com.example.boardcrud.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private String title;
    private String content;
    private String userName;
}
