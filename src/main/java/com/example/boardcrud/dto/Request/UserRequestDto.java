package com.example.boardcrud.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    @NotBlank(message = "사용자 이름은 공백이나 비워둘 수 없습니다.")
    @Size(max = 30, message = "사용자 이름은 30자를 넘길 수 없습니다.")
    private String userName;

    @NotBlank(message = "비밀번호는 공백이나 비워둘 수 없습니다.")
    private String password;
}
