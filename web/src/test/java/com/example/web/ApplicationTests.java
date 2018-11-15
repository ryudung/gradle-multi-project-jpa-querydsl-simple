package com.example.web;

import com.example.domain.post.repository.PostRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ApplicationTests extends AbstractSpringBootTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @DisplayName("postRepository_존재")
    @Test
    public void postRepository_존재() {
        assertNotNull(postRepository);
    }

    @DisplayName("queryFactory_존재")
    @Test
    public void queryFactory_존재(){
        assertNotNull(jpaQueryFactory);
    }
}
