package com.msa.springdemo_boardv1.service;

import com.msa.springdemo_boardv1.entity.Board;

public interface BoardService {
    void CreateBoard(Board board);

    void DeleteBoard(Long boardId);

    Board GetBoardById(Long boardId);

    Board UpdateBoard(Board board);

    long CountBoards();

    Board GetBoardByTitle(String title);

    Board GetBoardByContent(String content);

    Board GetBoardByWriter(String writer);

}
