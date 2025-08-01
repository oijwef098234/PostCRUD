package com.example.boardcrud.Service;

import com.example.boardcrud.Entity.Post;
import com.example.boardcrud.Repository.PostRepository;
import com.example.boardcrud.dto.Responsse.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReadService {
    private final PostRepository postRepository;

    public List<PostResponse> getPostRepository() {
        return postRepository.findAll()
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }

    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id) // 여기서 객체를 선언하고 dto를 이용하여 PostResponse형을 맞춰는거임
                .orElseThrow(() -> new RuntimeException("해당 게시글 없음")); // 그리고 orElseThrow는 예외 처리를 하는거임
        // 이거 예외처리 그냥 안하고 넘기면 안되냐 할 수도 있는데 찾아보니까 옵션값은 있을수도 있고 없을수도 있어서 꼭 예외처리를 해야한다고 함

        return new PostResponse(post); // 그리고 여기서 @Getter를 이용하여 PostResponse에서 자동으로 지원하는 getId를 이용하여 id를 생성자를 통해 가져옴
    }
}


