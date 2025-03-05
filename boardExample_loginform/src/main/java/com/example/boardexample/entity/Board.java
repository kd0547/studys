package com.example.boardexample.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(indexes = {
        @Index(name = "board_index_page",columnList = "createAt,id")
})
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String subject;

    private String author;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;


}
