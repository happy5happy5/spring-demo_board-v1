package com.msa.springdemo_boardv1.controller;

import com.msa.springdemo_boardv1.entity.Board;
import com.msa.springdemo_boardv1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list")
    public String list(){
        System.out.println("[BOARD CONTROLLER]list...");
        return "board/list";
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

    @GetMapping("/detail")
    public String detail(Long boardId, Model model){
        System.out.println("[BOARD CONTROLLER]detail...");
        Board board = boardService.GetBoardById(boardId);
        model.addAttribute("board", board);
        //detail로 redirect
        return "board/detail";
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


