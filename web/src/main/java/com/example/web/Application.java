package com.example.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import com.example.common.utils.StringUtil;

@Slf4j
@SpringBootApplication
@EntityScan("com.example.*")
public class Application implements ApplicationRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(StringUtil.addWord("hello", "ryudung"));
    }
}
