package com.wawa.basic.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Yang Xiaodong
 * 2013年12月3日 下午10:40:23
 */
public interface BasicDao {

    /** 
     * 增删改查
     * @param sql
     * @param entry
     * @throws Exception 
     * @create: 2013年12月11日 下午6:10:38 
     * @author: Yang Xiaodong
     * @history: 
     */
    public <T extends Serializable> void updateObject(String sql, T entry) throws Exception;

    /** 
     * 查询实体列表
     * @param sql
     * @param entry
     * @return
     * @throws Exception 
     * @create: 2013年12月11日 下午6:10:46 
     * @author: Yang Xiaodong
     * @history: 
     */
    <T extends Serializable> List<T> getObjectList(String sql, Map<String,?>paramMap,Class<T> clazz )
            throws Exception;

    /** 
     * 查询实体
     * @param sql
     * @param entry
     * @return
     * @throws Exception 
     * @create: 2013年12月11日 下午6:10:46 
     * @author: Yang Xiaodong
     * @history: 
     */
    <T extends Serializable> T getObject(String sql, Map<String, ?> paramMap, Class<T> clazz)
            throws Exception;

    /** 
     * 获取数据总数
     * @param sql
     * @param paramMap
     * @return
     * @throws Exception 
     * @create: 2013年12月11日 下午6:11:04 
     * @author: Yang Xiaodong
     * @history: 
     */
    int getCount(String sql, Map<String, ?> paramMap) throws Exception;

}
