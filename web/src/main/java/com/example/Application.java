package com.example;

import com.example.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *  jpa Entity, Repository 탐색을 @SpringBootApplication위치 부터 시작해서 하위로 탐색한다.
 *  multi-module로 개발할 때, domain(Entity)을 분리해서 진행하면, 탐색이 되지 않기 때문에
 *  Application 클래스 위치를 조정하면 scan 범위안에 들어가게 되어 잘 동작한다.
 *
 *  @EnableJpaRepositories를 통해 scan 범위를 고치게 되면 entityManagerFactoryRef를 통해서
 *  repository 탐색 범위를 수정해 줘야한다.
 *
 * */
@Slf4j
@SpringBootApplication
public class Application implements ApplicationRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(StringUtil.addWord("hello", "ryudung"));
    }
}
