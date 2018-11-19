package com.example.web.querydsl;

import com.example.domain.post.Post;
import com.example.domain.post.QPost;
import com.example.domain.post.repository.PostRepository;
import com.example.web.AbstractSpringBootTest;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class QueryDslTest extends AbstractSpringBootTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @BeforeEach
    public void setUp(){
        postRepository.save(new Post());
    }

    @DisplayName("queryDsl_테스트")
    @Test
    public void test(){
        QPost post = QPost.post;

        Post fetchedPost = jpaQueryFactory.
                selectFrom(post)
                .where(post.id.eq(1L))
                    .fetchFirst();

        assertEquals(new Long(1L), fetchedPost.getId());
    }
}
