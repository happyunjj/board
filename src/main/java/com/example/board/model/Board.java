package com.example.board.model;

import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board {
    private long bno; // 글번호
    private String title; // 제목
    private String content; // 내용
    private String regdate; // 게시물 등록일시
    private String moddate; // 게시물 수정일시

    public Board(long bno){
        this.bno = bno;
    }
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}