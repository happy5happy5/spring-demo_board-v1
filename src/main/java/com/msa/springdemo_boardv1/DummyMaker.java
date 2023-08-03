package com.msa.springdemo_boardv1;

import com.msa.springdemo_boardv1.entity.Board;
import com.msa.springdemo_boardv1.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DummyMaker implements CommandLineRunner {

    BoardRepository boardRepository;

    @Override
    public void run(String... args) throws Exception {
        Board board1 = Board.builder()
                .title("title1")
                .content("content1")
                .writer("writer1")
                .password("password1")
                .build();

        Board board2 = Board.builder()
                .title("title2")
                .content("content2")
                .writer("writer2")
                .password("password2")
                .build();

        Board board3 = Board.builder()
                .title("title3")
                .content("content3")
                .writer("writer3")
                .password("password3")
                .build();

        boardRepository.save(board1);
        boardRepository.save(board2);
        boardRepository.save(board3);

        System.out.println("Dummy data inserted");
    }

}
