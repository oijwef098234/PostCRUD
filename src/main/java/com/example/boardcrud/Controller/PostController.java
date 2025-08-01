package com.example.boardcrud.Controller;

import com.example.boardcrud.Service.CreateService;
import com.example.boardcrud.Service.DeleteService;
import com.example.boardcrud.Service.ReadService;
import com.example.boardcrud.Service.UpdateService;
import com.example.boardcrud.dto.Request.PostRequest;
import com.example.boardcrud.dto.Responsse.PostResponse;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/create") // 생성
    public void createPost(@RequestBody PostRequest postRequest) {
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
    public void updatePost(@RequestBody PostRequest postRequest, @PathVariable Long id) {
        updateService.updatePost(postRequest, id);
    }
}
