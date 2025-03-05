package com.example.boardexample.service;

import com.example.boardexample.entity.Board;
import com.example.boardexample.dto.BoardDto;
import com.example.boardexample.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> view(int page) {
        List<Board> boards = boardRepository.findPage(page);

        return boards.stream()
                .map(BoardDto::createDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long createPost(BoardDto boardDto) {
        return boardRepository.save(boardDto);
    }

    @Transactional
    public BoardDto postView(Long id, boolean viewPost) {
        Optional<Board> findBoard = boardRepository.findById(id);
        return findBoard.map(board -> {
            if(viewPost) {
                board.addView();
            }
            return BoardDto.createDto(board);
        }).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글은 존재하지 않습니다."));
    }

    @Transactional
    public void postLiked(long id) {
        if(boardRepository.updateLike(id) == 0) {
            throw new IllegalArgumentException("해당 게시글이 존재하지 않습니다.");
        }
    }
}
