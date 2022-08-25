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
    /* 게시물 목록 조회 */
    public List<Board> selectAll(int pageNum) {
        return boardMapper.getList(pageNum);
    }
    /* 즐겨찾기 목록 조회 */
    public List<Board> getBookmark(int pageNum) {
        return boardMapper.getBookmarks(pageNum);
    }
    /* 즐겨찾기 개수 조회 */
    public int getBookmarkCount() {
        return boardMapper.getBookmarkTotal();
    }
    /* 게시물 개수 조회 */
    public int getCount() {
        return boardMapper.getTotal();
    }
    /* 게시물 조회 */
    public Board readBoardPost(Long bno) {
        return boardMapper.readBoardPost(bno);
    }
    /* 게시물 작성 */
    public void write(Board board) {
        boardMapper.write(board);
    }
    /* 게시물 수정 */
    public void update(Board board) {
        boardMapper.update(board);
    }
    /* 게시물 삭제 */
    public void delete(long bno) {
        boardMapper.delete(bno);
    }
}
