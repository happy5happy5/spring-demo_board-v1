package com.msa.springdemo_boardv1.controller;

import com.msa.springdemo_boardv1.entity.Board;
import com.msa.springdemo_boardv1.repository.BoardRepository;
import com.msa.springdemo_boardv1.service.BoardService;
import com.msa.springdemo_boardv1.utils.PageMaker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.IntStream;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;


    @GetMapping("/list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer pageNum){
        System.out.println("[BOARD CONTROLLER]list...");
        Page<Board> pageResult = boardService.GetBoardListPaging(pageNum, 4);
        PageMaker pageMaker = new PageMaker(pageResult,10);
        model.addAttribute("boardList", pageResult.getContent());
        model.addAttribute("pageMaker", pageMaker);
        return "board/list";
    }
    @PostConstruct
    public void init(){
        System.out.println("[BOARD CONTROLLER]init...");
        IntStream.rangeClosed(1, 125).forEach(i -> {
        Board board = Board.builder()
                .title("title" + i)
                .content("content" + i)
                .writer("writer" + i)
                .password("password" + i)
                .build();
        boardRepository.save(board);
        });
    }



//    @RequestMapping("/list2")
//    public String list2(){
//        System.out.println("[BOARD CONTROLLER]list2...");
//        return "board/list2";
//    }
//
//    @RequestMapping("/list3")
//    public String list3(){
//        System.out.println("[BOARD CONTROLLER]list3...");
//        return "board/list3";
//    }

    @PostMapping("/create")
    public String create(Board board, Model model){
        System.out.println("[BOARD CONTROLLER]create...");
        boardService.CreateBoard(board);
        model.addAttribute("board", board);
        //detail로 redirect
        return "redirect:/board/detail";
    }

    @GetMapping("/create")
    public String createForm(){
        System.out.println("[BOARD CONTROLLER]createForm...");
        return "board/create";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Long boardId, Model model){
        System.out.println("[BOARD CONTROLLER]detail...");
        Board board = boardService.GetBoardById(boardId);
        model.addAttribute("board", board);
        //detail로 redirect
        return "board/detail?boardId="+boardId;
    }

    @PostMapping("/update")
    public String update(Board board, Model model){
        System.out.println("[BOARD CONTROLLER]update...");
        boardService.UpdateBoard(board);
        model.addAttribute("board", board);
        //detail로 redirect
        return "redirect:/board/detail";
    }

    @PostMapping("/delete")
    public String delete(Long boardId){
        System.out.println("[BOARD CONTROLLER]delete...");
        boardService.DeleteBoard(boardId);
        //list로 redirect
        return "redirect:/board/list";
    }

//    @GetMapping("/count")
//    public String count(Model model){
//        System.out.println("[BOARD CONTROLLER]count...");
//        long count = boardService.CountBoards();
//        model.addAttribute("count", count);
//        return "board/count";
//    }
}


