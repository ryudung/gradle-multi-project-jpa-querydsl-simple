package com.example.web;

import com.example.domain.post.repository.PostRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    PostRepository postRepository;

    @Autowired
    JPAQueryFactory queryFactory;

    @DisplayName("postRepository_존재")
    @Test
    public void postRepository_존재() {
        assertNotNull(postRepository);
    }

    @DisplayName("queryFactory_존재")
    @Test
    public void queryFactory_존재(){
        assertNotNull(queryFactory);
    }
}
