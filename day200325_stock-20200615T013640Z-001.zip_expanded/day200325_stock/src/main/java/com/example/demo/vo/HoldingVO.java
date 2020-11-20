package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoldingVO {

	private int holdingid;
	private String stock_item;
	private int stockid;
	private int userno;
	private int buyingprice;
	private int qty;
}
