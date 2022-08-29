package com.example.board.repository;
import com.example.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    /* 게시물 목록 조회 */
    List<Board> getList(int pageNum);
    /* 즐겨찾기 목록 조회 */
    List<Board> getBookmarks();
    /* 즐겨찾기에 조회 (글삭제 시 북마크에 있는지 여부 확인) */
    Board getBookmark(long bno);
    /* 게시물 개수 조회 */
    int getTotal();
    /* bno로 게시물 조회 */
    Board readBoardPost(long bno);
    /* 게시물 작성 */
    void write(Board board);
    /* 북마크 추가 */
    void createBookmark(long bno);
    /* 게시물 수정 */
    void update(Board board);
    /* 게시물 삭제 */
    void delete(long bno);
    /* 북마크 삭제 */
    void deleteBookmark(long bno);

}
