package com.example.web.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Objects;



/**
 *  multi DataSource를 사용하기 위한 Config.
 * */
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.example.domain",
//        entityManagerFactoryRef = "baseEntityManager",
//        transactionManagerRef = "baseTransactionManager"
//)
public class DataBaseConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean baseEntityManager(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(baseDataSource())
                .packages("com.example.domain")// scan 범위 변경가능.
                .build();
    }

    @Bean
    public DataSource baseDataSource () {
        return DataSourceBuilder.create()
                .username("root")
                .password("123456")
                .url("jdbc:mysql://localhost:3306/test_db?useSSL=false&serverTimezone=UTC")
                .build();
    }

    @Bean
    public PlatformTransactionManager baseTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(
                Objects.requireNonNull(baseEntityManager(builder).getObject())
        );
    }

}
