package com.proj1.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Board {
    private int id;
    private String title;
    private String content;
    private LocalDateTime inserted;
    private Integer memberId;
    private String writer;
}
