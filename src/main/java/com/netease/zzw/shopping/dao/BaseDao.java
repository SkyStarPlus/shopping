package com.netease.zzw.shopping.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

//@Repository
public interface BaseDao {
    Session session();

    HibernateTemplate getTemplate();

    <T> List<T> findBySql(String sql) throws Exception;
}
