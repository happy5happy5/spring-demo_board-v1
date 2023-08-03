package com.msa.springdemo_boardv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping("/list")
    public String list(){
        System.out.println("[BOARD CONTROLLER]list...");
        return "board/list";
    }

    @RequestMapping("/list2")
    public String list2(){
        System.out.println("[BOARD CONTROLLER]list2...");
        return "board/list2";
    }

    @RequestMapping("/list3")
    public String list3(){
        System.out.println("[BOARD CONTROLLER]list3...");
        return "board/list3";
    }

}
