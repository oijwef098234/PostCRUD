package com.example.boardcrud.Service;

import com.example.boardcrud.Entity.Post;
import com.example.boardcrud.Repository.PostRepository;
import com.example.boardcrud.dto.Request.PostRequest;
import com.example.boardcrud.exception.NoWordException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateService {
    private final PostRepository postRepository;

    public void createPost(PostRequest postRequest) {
        String title = postRequest.getTitle();
        String content = postRequest.getContent();

        List<String> noWord = List.of("개병신", "씨발", "장애인", "엄마", "아빠");

        for(String word : noWord) {
            if(title.contains(word)) {
                throw new NoWordException("제목", word);
            }
        }

        for(String word : noWord) {
            if(content.contains(word)) {
                throw new NoWordException("본문", word);
            }
        }

        Post post = new Post(
                postRequest.getTitle(),
                postRequest.getContent(),
                postRequest.getUserName()
        );

        postRepository.save(post);
    }

}
