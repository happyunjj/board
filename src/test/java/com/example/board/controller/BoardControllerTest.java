package com.example.board.controller;

import com.example.board.repository.BoardMapper;
import com.example.board.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private BoardService boardService;
    @MockBean
    private BoardMapper boardMapper;

    @Test
    public void getList() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/board/list"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getBookmarks() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/board/bookmark"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

