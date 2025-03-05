package com.example.boardexample.controller;

import com.example.boardexample.dto.BoardDto;
import com.example.boardexample.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.boardexample.dto.PageDto;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String view(
            @RequestParam(defaultValue = "1") int page,
            Model model) {
        List<BoardDto> boardList = boardService.view(page);
        PageDto pageDto = new PageDto();
        pageDto.setTotalPage(1000L);
        pageDto.setNumber((long)page);

        model.addAttribute("boardList",boardList);
        model.addAttribute("page",pageDto);

        return "boardView";
    }


}
