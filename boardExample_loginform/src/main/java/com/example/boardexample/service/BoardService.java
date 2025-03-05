package com.example.boardexample.service;

import com.example.boardexample.entity.Board;
import com.example.boardexample.dto.BoardDto;
import com.example.boardexample.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
}
