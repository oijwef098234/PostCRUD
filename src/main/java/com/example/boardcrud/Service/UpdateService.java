package com.example.boardcrud.Service;

import com.example.boardcrud.Entity.Post;
import com.example.boardcrud.Repository.PostRepository;
import com.example.boardcrud.dto.Request.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateService {
    private final PostRepository postRepository;

    @Transactional
    public void updatePost(PostRequest postRequest, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 글입니다."));

        post.updatePost(postRequest.getTitle(), postRequest.getContent(), postRequest.getUserName());
    }
}
