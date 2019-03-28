package com.netease.zzw.shopping.dao;

import com.netease.zzw.shopping.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    /*
     * 根据用户名查询
     * */
    @Query("select t from User t where t.userName = :userName")
    User findByUserName(@Param("userName") String userName);

    /*
     * 查询全部
     * */
    @Query("select t from User t")
    List<User> find();
}
