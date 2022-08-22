package com.example.board.model;

import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board {
    private Long bno;
    private String title;
    private String content;
    private String regdate;
    private String bookmark;
    private String moddate;

    public Board(Long bno){
        this.bno = bno;
    }
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}