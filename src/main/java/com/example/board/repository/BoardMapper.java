package com.example.board.repository;
import com.example.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getList();
    List<Board> getList(Long[] bnos);
    Board readBoardPost(Long bno);
    void write(Board board);
    void update(Board board);
    void delete(Board board);

}
