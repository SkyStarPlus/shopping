package com.netease.zzw.shopping.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

//@Repository
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
//    @Autowired
//    public void setSessionFactoryOverride(SessionFactory sessionFactory) {
//        super.setSessionFactory(sessionFactory);
//    }


    @Override
    public Session session() {
        return null;
    }

    @Override
    public HibernateTemplate getTemplate() {
        return null;
    }

    @Override
    public <T> List<T> findBySql(String sql) throws Exception {
        return null;
    }
}
