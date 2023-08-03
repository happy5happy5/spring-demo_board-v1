package com.msa.springdemo_boardv1.service.impl;

import com.msa.springdemo_boardv1.entity.Board;
import com.msa.springdemo_boardv1.repository.BoardRepository;
import com.msa.springdemo_boardv1.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private BoardRepository boardRepository;

    @Override
    public void CreateBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void DeleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    @Override
    public Board GetBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElse(null);
    }

    @Override
    public void UpdateBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public long CountBoards() {
        return boardRepository.count();
    }

    @Override
    public Board GetBoardByTitle(String title) {
        return boardRepository.findByTitle(title);
    }

    @Override
    public Board GetBoardByContent(String content) {
         return boardRepository.findByContent(content);
    }

    @Override
    public Board GetBoardByWriter(String writer) {
        return boardRepository.findByWriter(writer);
    }

    @Override
    public Page<Board> GetBoardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Override
    public Page<Board> GetBoardListPaging(Integer pageNum, int i) {
        return boardRepository.findAll(PageRequest.of(pageNum - 1, i));
    }
}
