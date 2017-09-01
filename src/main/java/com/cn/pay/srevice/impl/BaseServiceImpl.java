package com.cn.pay.srevice.impl;

import com.cn.pay.dao.IBaseDao;
import com.cn.pay.srevice.inf.IBaseService;
import com.cn.pay.utils.ObjectQuery;
import com.cn.pay.utils.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 项目名称:   公共服务层
 * 包名称:com.cn.pay.srevice.impl
 * 类名称:BaseServiceImpl.java
 * 作者：miao
 * 创建时间： 2017年6月26日 上午11:29:11
 */
@WebService
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Resource
    private IBaseDao<T> baseDao;

    public void save(T entity) throws Exception {
        baseDao.save(entity);
    }

    public void update(T entity) throws Exception {
        baseDao.update(entity);
    }

    public void deleteById(Serializable id) throws Exception {
        baseDao.deleteById(id);
    }

    public T getById(Serializable id) throws Exception {
        return baseDao.getById(id);
    }

    public List<T> getByWhere(HashMap<String, Object> params) throws Exception {
        return baseDao.getByWhere(params);
    }


    public List<T> getAll() throws Exception {
        return baseDao.getAll();
    }

    /**
     * 方法名：getPageList
     *
     * @param queryObject 查询对象
     * @return 返回类型：PageSupport<T>
     * 说明：分页查询\一般查询（当queryObject为null,则作页面查询，就是一般结果集）
     */

    public PageResult<T> findPage(ObjectQuery queryObject) throws Exception {
        PageResult<T> pageResult = new PageResult<T>();
        //1)分页查询
        if (queryObject != null) {
            Integer totalRecord = 0;
            //查询总条数
            totalRecord = this.findCount(queryObject);
            if (totalRecord == null || totalRecord.intValue() <= 0) {
                pageResult.setRecords(new ArrayList<T>());
                return pageResult;
            }
            //当前起始位置>总条数（查询出来），则起始位置-页面大小
            int startIndex = queryObject.getPageOffset();
            if (startIndex >= totalRecord) {
                startIndex = startIndex - queryObject.getPageSize();
                queryObject.setPageOffset(startIndex);
            }
            //查询结果集
            //封装：结果集、总条数、当前页、总页数
            pageResult.setRowCount(totalRecord);
            int pageCount = totalRecord / queryObject.getPageSize();
            if (totalRecord % queryObject.getPageSize() > 0) {
                pageCount++;
            }
            pageResult.setPageCount(pageCount);
            //2)一般查询（没有分页）
            List<T> resultList = this.findQuery(queryObject);
            pageResult.setPageNow(queryObject.getPageNow()); //当前页
            pageResult.setRecords(resultList);
        }
        return pageResult;
    }

    /**
     * 方法名：findQuery
     * @param objectQuery
     * @return List<T>
     * @throws Exception 返回类型：List<T>
     *                   说明：查询结果集 （分页查询基本实现，若自定义，@Override即可）
     */
    public List<T> findQuery(ObjectQuery objectQuery) throws Exception {
        return baseDao.findQuery(objectQuery);
    }

    /**
     * 方法名：findCount
     * @param objectQuery
     * @return
     * @throws Exception 返回类型：Integer
     * 说明：查询总条数 （分页查询基本实现，若自定义，@Override即可）
     */
    public Integer findCount(ObjectQuery objectQuery) throws Exception {
        return baseDao.findCount(objectQuery);
    }

    public PageInfo<T> queryPage(ObjectQuery queryObject) throws Exception {
        PageHelper.offsetPage(queryObject.getPageOffset(), queryObject.getLimit());
        List<T> list = baseDao.queryPage(queryObject);
        return new PageInfo<T>(list);
    }

}
