package com.example.demo.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVo {
	// 우선은 기본적인 게시판 만들기부터. 이후 차츰 기능 늘려서 다시 도전하기로.
	private int no;
	private String title;
	private String content;
	private String writer;
	private int hit;
	private Date regdate;
}
