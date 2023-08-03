package com.msa.springdemo_boardv1.service;

import com.msa.springdemo_boardv1.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    void CreateBoard(Board board);

    void DeleteBoard(Long boardId);

    Board GetBoardById(Long boardId);

    void UpdateBoard(Board board);

    long CountBoards();

    Board GetBoardByTitle(String title);

    Board GetBoardByContent(String content);

    Board GetBoardByWriter(String writer);

    Page<Board> GetBoardList(Pageable pageable);

    Page<Board> GetBoardListPaging(Integer pageNum, int i);
}
