package com.example.web;

import com.example.domain.Post;
import com.example.domain.QPost;
import com.example.web.repo.PostRepository;
import com.querydsl.core.types.Predicate;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationTests {

    @Autowired
    PostRepository postRepository;

    @Before
    public void setUp() throws Exception {
        postRepository.save(new Post());
    }

    @Test
    public void 테스트_존재() {

        Assertions.assertThat(postRepository.existsById(1L)).isTrue();
    }


    @Test
    public void querydsl_test() {

        QPost qpost = QPost.post;

        Predicate predicate =  qpost.id.eq(1L);

        Post post = postRepository.findOne(predicate).get();

        Assertions.assertThat(post.getId()).isEqualTo(1L);
    }
}
