package com.example.boardcrud.Controller;

import com.example.boardcrud.Service.*;
import com.example.boardcrud.dto.Request.PostRequest;
import com.example.boardcrud.dto.Request.UserRequestDto;
import com.example.boardcrud.dto.Responsse.PostResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boardcrud")
public class PostController {
    private final CreateService createService;
    private final ReadService readService;
    private final DeleteService deleteService;
    private final UpdateService updateService;
    private final UserService userService;

    @PostMapping("/create") // 생성
    public void createPost(@Valid @RequestBody PostRequest postRequest) {
        createService.createPost(postRequest);
    }

    @GetMapping("/all") // 전체 조회
    public List<PostResponse> getPostRepository() {
        return readService.getPostRepository();
    }

    @GetMapping("/{id}") //. 아이디조회
    public PostResponse findById(@PathVariable Long id) {
        return readService.findById(id);
    }

    @DeleteMapping("/{id}") // 삭제
    public void deleteById(@PathVariable Long id) {
        deleteService.deletePost(id);
    }

    @PatchMapping("/{id}")
    public void updatePost(@Valid @RequestBody PostRequest postRequest, @PathVariable Long id) {
        updateService.updatePost(postRequest, id);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody UserRequestDto dto) {
        userService.signUp(dto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserRequestDto dto) {
        String result = userService.login(dto);
        return ResponseEntity.ok(result);
    }
}
