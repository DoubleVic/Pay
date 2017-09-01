package com.cn.pay.dao;

import com.cn.pay.utils.ObjectQuery;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface IBaseDao<T> {

    // 保存
    void save(T entity) throws Exception;

    // 修改
    int update(T entity) throws Exception;

    // 删除
    void deleteById(Serializable id) throws Exception;

    // 查询（ID）
    T getById(Serializable id) throws Exception;

    // 查询（where）
    List<T> getByWhere(HashMap<String, Object> map) throws Exception;

    // 查询（All）
    List<T> getAll() throws Exception;

    // 查询（分页查询_结果集）
    List<T> findQuery(ObjectQuery objectQuery) throws Exception;

    // 查询（分页查询_数量）
    Integer findCount(ObjectQuery objectQuery) throws Exception;

    /**
     * 使用插件分页
     * @param params 查询条件： 不包含分页数据
     * @return
     */
    List<T> queryPage(Object params);
}
