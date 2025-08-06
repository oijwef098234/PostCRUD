package com.example.boardcrud.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {

    @NotBlank(message = "제목은 비워둘수 없습니다.")
    @Size(max = 100, message = "제목은 100자까지만 가능합니다")
    private String title;

    @NotNull(message = "본문을 비워둘수 없습니다.")
    @Size(max = 1000, message = "본문은 1000자를 넘길 수 없습니다.")
    private String content;

    @NotBlank(message = "이름을 비워둘수 없습니다.")
    private String userName;
}
