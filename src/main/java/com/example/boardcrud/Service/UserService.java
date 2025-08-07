package com.example.boardcrud.Service;

import com.example.boardcrud.Entity.Post;
import com.example.boardcrud.Repository.PostRepository;
import com.example.boardcrud.dto.Request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserRequestDto dto) {
        if (postRepository.findByUserName(dto.getUserName()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 사용자 이름입니다.");
        }

        String encodedPassword = passwordEncoder.encode(dto.getPassword());

        Post post = new Post();
        post.setUserName(dto.getUserName());
        post.setPassword(encodedPassword);

        postRepository.save(post);
    }

    public String login(UserRequestDto dto) {
        Post post = postRepository.findByUserName(dto.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 사용자 입니다."));
        if (!passwordEncoder.matches(dto.getPassword(), post.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return "로그인 성공";
    }
}
