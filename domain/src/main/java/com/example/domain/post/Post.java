package com.example.domain.post;

import com.example.domain.converter.LocalDateTimeConverter;
import com.example.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor

@EntityListeners(AuditingEntityListener.class)
@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @LastModifiedDate
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(nullable = false)
    private LocalDateTime updateAt;

    @CreatedDate
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(updatable = false, nullable = false)
    private LocalDateTime createAt;
}
