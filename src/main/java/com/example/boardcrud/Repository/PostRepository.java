package com.example.boardcrud.Repository;

import com.example.boardcrud.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

//@Repository
//public interface PostRepository extends JpaRepository<Post, Long> {
//
//}