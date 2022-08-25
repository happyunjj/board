package com.example.board.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PageDTO {
    private static int PAGE_AMOUNT = 5;

    private int total; // 전체 게시물 개수
    private int pageNum; // 현재 페이지

    private int startPage; // 목록에 보여지는 페이지 중 첫 페이지
    private int endPage; // 목록에 보여지는 마지막 페이지
    private boolean prev; // true : 버튼 활성화 , false : 버튼 비활성화
    private boolean next;

    public PageDTO(int total,int pageNum) {
        this.total = total;
        this.pageNum =pageNum;

        //페이지 목록 중 보여지는 마지막페이지 구하기
        endPage =((pageNum-1)/PAGE_AMOUNT +1) * PAGE_AMOUNT;

        //페이지 목록 중 보여지는 시작페이지 구하기
        startPage = endPage -PAGE_AMOUNT +1;

        // 총 마지막 페이지 구하기 (전체 게시글수 + 한페이지당글개수 -1) / 한페이지당 글개수
        int realEnd= (total + 9) / 10 ;

        //보여질 마지막 페이지가 총 마지막페이지 보다 크면 총 마지막페이지 작으면 보여질 마지막페이지
        endPage= realEnd< endPage ? realEnd:endPage;

        //시작페이지가 1보다 크면 prev를 true로 활성화
        prev = startPage > 1;

        //보여지는 마지막페이지가 진짜 마지막페이지보다 작으면 next활성화
        next = endPage < realEnd;
    }
}
