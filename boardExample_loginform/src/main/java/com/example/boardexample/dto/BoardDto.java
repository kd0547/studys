package com.example.boardexample.dto;

import com.example.boardexample.entity.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;

    private String title;

    private String subject;

    private String author;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private int like;

    private int viewCount;

    public static BoardDto createDto(Board board) {
        BoardDto boardDto = new BoardDto();
        boardDto.setId(board.getId());
        boardDto.setTitle(board.getTitle());
        boardDto.setAuthor(board.getAuthor());
        boardDto.setSubject(board.getSubject());
        boardDto.setCreateAt(board.getCreateAt());
        boardDto.setUpdateAt(board.getUpdateAt());
        boardDto.setLike(board.getLikes());
        boardDto.setViewCount(board.getViewCount());
        return boardDto;
    }
}
