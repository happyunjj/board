package com.example.board.controller;


import com.example.board.model.Board;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("board/list")
    public List<Board> getList(){
        return boardService.selectAll();
    }

    @GetMapping("/board/{bno}")
    public Board read(@PathVariable Long bno) { return boardService.readBoardPost(bno); }

    @PostMapping("/board/write")
    public void write(@RequestBody Board board){ boardService.write(board); }

    @PostMapping("/board/update")
    public  void update(@RequestBody Board board) { boardService.update(board);}
    @PostMapping("/board/delete")
    public void delete(@RequestBody Board board) { boardService.delete(board); }
    @GetMapping("/board/bookmark")
    public List<Board> getBookmarks(Long[] bookmark) { return boardService.getBookmark(bookmark); }
}
