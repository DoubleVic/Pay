package com.cn.pay.utils;

import lombok.Data;

import java.util.List;
@Data
public class PageResult<T>{

	//private int total;		//总条数
	//private List<T> rows;	//结果集
	private int rowCount;		//总条数
	private int pageCount;		//总页数
	private List<T> records;	//结果集
	private Integer pageNow = 1;	//当前页

}
