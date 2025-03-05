package com.example.boardexample.entity;

import com.example.boardexample.dto.BoardDto;
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

    @Column(columnDefinition = "int default 0")
    private int likes;

    @Column(columnDefinition = "int default 0")
    private int viewCount;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    public static Board createBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setSubject(boardDto.getSubject());
        board.setAuthor(boardDto.getAuthor());
        board.setCreateAt(LocalDateTime.now());
        board.setUpdateAt(LocalDateTime.now());

        return board;
    }

    public void addView() {
        this.viewCount++;
    }

    public void addLike() {
        this.likes++;
    }
}
