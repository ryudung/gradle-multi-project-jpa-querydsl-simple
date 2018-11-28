package com.example.domain.post.repository;

import com.example.domain.post.Post;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @DisplayName("save 연습")
    @Test
    public void save() {
        //given
        Post post = Post.builder()
                .content("내용")
                .build();

        //when
        Post savedPost = postRepository.save(post);

        postRepository.flush();
        entityManager.clear();

        Post finedPost = postRepository.findById(savedPost.getId()).get();

        //then
        assertEquals(post.getContent(), finedPost.getContent());
    }
}