package com.example.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
}
