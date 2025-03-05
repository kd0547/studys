package com.example.boardexample.controller;

import com.example.boardexample.dto.BoardDto;
import com.example.boardexample.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.boardexample.dto.PageDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @GetMapping("/post/{id}")
    public String postView(
            HttpServletRequest request,
            @PathVariable Long id,
            Model model) {

        boolean viewPost = Boolean.TRUE.equals(request.getAttribute("viewPost"));

        BoardDto boardDto = boardService.postView(id,viewPost);
        model.addAttribute("post",boardDto);

        return "postView";
    }


    @GetMapping("/board/new")
    public String create(Model model) {

        BoardDto boardDto = new BoardDto();
        boardDto.setAuthor("kimdongwook");

        model.addAttribute("boardDto",boardDto);
        return "postCreate";
    }

    @ResponseBody
    @PostMapping("/post/{id}/like")
    public ResponseEntity<String> addLikes(@PathVariable("id") long id) {
        boardService.postLiked(id);
        return ResponseEntity.ok("");
    }

    @PostMapping("/board/new")
    public String saveCreate(@ModelAttribute BoardDto boardDto) {
        Long id = boardService.createPost(boardDto);

        return "redirect:/list";
    }

}
