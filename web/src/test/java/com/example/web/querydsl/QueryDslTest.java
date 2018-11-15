package com.example.web.querydsl;

import com.example.domain.post.Post;
import com.example.domain.post.QPost;
import com.example.domain.post.repository.PostRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class QueryDslTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    JPAQueryFactory queryFactory;

    @BeforeEach
    public void setUp(){
        postRepository.save(new Post());
    }

    @DisplayName("queryDsl_테스트")
    @Test
    public void test(){
        QPost post = QPost.post;

        Post fetchedPost = queryFactory.
                selectFrom(post)
                .where(post.id.eq(1L))
                    .fetchFirst();

        assertEquals(new Long(1L), fetchedPost.getId());
    }
}
