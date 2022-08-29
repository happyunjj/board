package com.example.board.service;

import com.example.board.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void selectAll(){
        List<Board> boardList = boardService.selectAll(1);
        log.info("boardposts : {}", boardList);
    }

    @Test
    public void getBookmark(){
        List<Board> bookmarkList = boardService.getBookmarks();
        log.info("boardposts : {}", bookmarkList);
    }

    @Test
    public void readBoardPost() {
        Board board = boardService.readBoardPost(58L);
        log.info("Board :",board);
    }

    @Test
    public void write(){
        Board board = new Board();
        board.setTitle("게시글 테스트");
        board.setContent("게시글 테스트 내용");
        boardService.write(board);
    }

    @Test
    public void update(){
        Board board = new Board();
        board.setBno(58L);
        board.setTitle("게시글 업데이트 테스트");
        board.setContent("게시글 업데이트 내용");
        boardService.update(board);
    }

    @Test
    public void delete(){
        boardService.delete(38L);
    }

}
