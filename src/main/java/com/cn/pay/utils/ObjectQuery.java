package com.cn.pay.utils;

import lombok.Data;

/**
 *	类名称：QueryObject
 *	类描述：查询对象
 *	创建人：miao
 *	创建时间：2017-5-2上午10:53:07
 */
@Data
public class ObjectQuery {
	private int pageSize = 10; // 页面大小
	private int pageNow = 1; // 第几页(当前页)
	private int pageOffset; // 开始位置
	private int limit; // 每页显示多少
}