package com.example.board.controller;


import com.example.board.model.Board;
import com.example.board.model.PageDTO;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    /**
     * @param pageNum
     * 현재 페이지값을 파라미터로 받아 해당페이지에 보여줄 게시물목록과
     * 아래 표시할 페이지목록의 값을 제이슨으로 반환합니다.
     * 아래 getBookmarks 메서드도 동일합니다.
     */
    @GetMapping("/board/list")
    public @ResponseBody Map<String,Object> getList(@RequestParam(value = "pageNum", required = true, defaultValue ="1") int pageNum){
        Map<String,Object> map = new HashMap<>(); // 여러 속성을 담아 return 하기위해 맵 객체 생성
        map.put("list",boardService.selectAll(pageNum)); // 게시글리스트
        map.put("page",new PageDTO(boardService.getCount(), pageNum)); // 페이지 정보
        return map;
    }

    @GetMapping("/board/bookmark")
    public @ResponseBody List<Board> getBookmarks() {
        // 즐겨찾기의 경우 페이징을 프론트단에서 하기 때문에 리스트만 반환
        return boardService.getBookmarks();
    }

    /**
     * @param bno
     * bno로 조회하고싶은 게시물을 조회합니다.
     */
    @GetMapping("/board/{bno}")
    public Board read(@PathVariable long bno) {
        return boardService.readBoardPost(bno);
    }

    /**
     * @param board
     * 게시물을 등록합니다.
     */
    @PostMapping("/board/write")
    public void write(@RequestBody Board board) {
        boardService.write(board);
    }

    /**
     * @param bno
     * 즐겨찾기에 추가합니다.
     */
    @GetMapping("/board/bookmark/{bno}")
    public void createBookmark(@PathVariable long bno) {
        boardService.createBookmark(bno);
    }

    /**
     * @param board
     * 게시물을 수정합니다.
     */
    @PutMapping("/board/{bno}")
    public void update(@RequestBody Board board) {
        boardService.update(board);
    }

    /**
     * @param bno
     * 게시물을 삭제합니다.
     */
    @DeleteMapping("/board/{bno}")
    public void delete(@PathVariable long bno) {
        boardService.delete(bno);
    }

    /**
     * @param bno
     * 즐겨찾기를 삭제합니다.
     */
    @DeleteMapping("/board/bookmark/{bno}")
    public void deleteBookmark(@PathVariable long bno) {
        boardService.deleteBookmark(bno);
    }
}
