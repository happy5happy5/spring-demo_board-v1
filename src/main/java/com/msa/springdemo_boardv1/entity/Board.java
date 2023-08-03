package com.msa.springdemo_boardv1.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "board")
public class Board {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "board_type")
    private String boardType;
    @Column(name = "title")
    private String title;
//    @Column(name = "email")
//    private String email;
    @Column(name = "content")
    private String content;
    @Column(nullable = false, name = "writer")
    private String writer;
    @Column(nullable = false, name = "password")
    private String password;
    @Column(name = "view_cnt")
    private int viewCnt;
    @Column(name = "reply_cnt")
    private int replyCnt;
    @Column(name = "like_cnt")
    private int likeCnt;
    @Column(name = "dislike_cnt")
    private int dislikeCnt;

    @CreationTimestamp
    @Column(name = "reg_date")
    private String regDate;
    @UpdateTimestamp
    @Column(name = "mod_date")
    private String modDate;

}
