package com.msa.springdemo_boardv1.utils;

import com.msa.springdemo_boardv1.entity.Board;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class PageMaker {

    private Page<Board> page;
    private Pageable pageable;
    private int currentPage;
    private int totalPages;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private boolean hasNextGroup;
//    private int pageButtonCnt;
    private List<Integer> pageNumList;
    //Page<Board> pageResult = boardService.GetBoardListPaging(pageNum, 4); 의 정보를 사용해서 PageMaker를 생성한다.
    public PageMaker(Page<Board> page, int pageButtonCnt) {
        this.page = page;
        this.pageable = page.getPageable();
        this.currentPage = this.pageable.getPageNumber() + 1;
        this.totalPages = page.getTotalPages();
        int tempEndPage = (int)(Math.ceil((double)this.currentPage / (double)pageButtonCnt) * (double)pageButtonCnt);
        this.startPage = tempEndPage - pageButtonCnt + 1;
        this.endPage = Math.min(this.totalPages, tempEndPage);
        this.prev = this.startPage > 1;
        this.next = this.endPage < this.totalPages;
        this.hasNextGroup = this.endPage < this.totalPages;
        this.pageNumList = (List)IntStream.rangeClosed(this.startPage, this.endPage).boxed().collect(Collectors.toList());
    }
    // getters and setters
}

