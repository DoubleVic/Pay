package com.cn.pay.srevice.inf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.cn.pay.utils.ObjectQuery;
import com.cn.pay.utils.PageResult;
import com.github.pagehelper.PageInfo;

public interface IBaseService<T> {

	// 保存
	void save(T entity) throws Exception;
	// 修改
	void update(T entity) throws Exception;
	// 删除
	void deleteById(Serializable id) throws Exception;
	// 查询（ID）
	T getById(Serializable id) throws Exception;
	// 查询（where）
	List<T> getByWhere(HashMap<String, Object> params) throws Exception;
	// 查询（All）
	List<T> getAll() throws Exception;
	// 查询(分页 查询)
	PageResult<T> findPage(ObjectQuery queryObject) throws Exception;
	//使用插件分页
	PageInfo<T> queryPage(ObjectQuery queryObject) throws Exception;
}
