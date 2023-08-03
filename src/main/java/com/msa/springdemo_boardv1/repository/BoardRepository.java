package com.msa.springdemo_boardv1.repository;

import com.msa.springdemo_boardv1.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByTitle(String title);

    Board findByContent(String content);

    Board findByWriter(String writer);
}
