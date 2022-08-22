package com.example.board.service;

import com.example.board.model.Board;
import com.example.board.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardMapper boardMapper;

    public List<Board> selectAll() {
        return boardMapper.getList();
    }
    public List<Board> getBookmark(Long[] bookmark) { return boardMapper.getList(bookmark); }
    public Board readBoardPost(Long bno) { return boardMapper.readBoardPost(bno); }
    public void write(Board board) {
        boardMapper.write(board);
    }
    public void update(Board board) { boardMapper.update(board); }
    public void delete(Board board) { boardMapper.delete(board);}
}
