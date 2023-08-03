package com.msa.springdemo_boardv1.repository;

import com.msa.springdemo_boardv1.entity.Board;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.lang.NonNullApi;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByTitle(String title);

    Board findByContent(String content);

    Board findByWriter(String writer);

    @NonNull
    Page<Board> findAll(Pageable pageable);
}
