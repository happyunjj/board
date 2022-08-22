package com.example.board.controller;

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
public class BoardControllerTest {
    @Autowired
    private BoardController boardController;

    @Test
    public void getList() {
        List<Board> boardList = boardController.getList();
        log.info("boardposts : {}", boardList);
    }
}
