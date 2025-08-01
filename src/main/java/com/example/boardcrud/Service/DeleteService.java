package com.example.boardcrud.Service;

import com.example.boardcrud.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteService {
    private final PostRepository postRepository;

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

}
