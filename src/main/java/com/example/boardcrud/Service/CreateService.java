package com.example.boardcrud.Service;

import com.example.boardcrud.Entity.Post;
import com.example.boardcrud.Repository.PostRepository;
import com.example.boardcrud.dto.Request.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateService {
    private final PostRepository postRepository;

    public void createPost(PostRequest postRequest) {
        Post post = new Post(
                postRequest.getTitle(),
                postRequest.getContent(),
                postRequest.getUserName()
        );

        postRepository.save(post);
    }

}
