package com.wawa.basic.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.wawa.basic.dao.BasicDao;

/**
 * @author Yang Xiaodong
 * 2013年12月3日 下午10:40:17
 */
public class BasicDaoImpl implements BasicDao {

    public NamedParameterJdbcTemplate jdbcTemplate;

    public NamedParameterJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /** 
     * @see com.wawa.basic.dao.BasicDao#updateObject(java.lang.String, java.io.Serializable)
     */
    public <T extends Serializable> void updateObject(String sql, T entry) throws Exception {
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(entry);
        jdbcTemplate.update(sql, paramSource);
    }

    /** 
     * @see com.wawa.basic.dao.BasicDao#getObjectList(java.lang.String, java.io.Serializable)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T extends Serializable> List<T> getObjectList(String sql, Map<String, ?> paramMap,
            Class<T> clazz) throws Exception {
        List<T> list = (List<T>)jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper(clazz));
        return list;
    }

    public int getCount(String sql, Map<String, ?> paramMap) throws Exception {
        int count = jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
        return count;
    }

    public <T extends Serializable> T getObject(String sql, Map<String, ?> paramMap, Class<T> clazz)
            throws Exception {
        T t = jdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(clazz));
        return t;
    }

}
