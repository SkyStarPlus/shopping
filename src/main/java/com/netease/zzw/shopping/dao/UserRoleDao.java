package com.netease.zzw.shopping.dao;

import com.netease.zzw.shopping.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao extends JpaRepository<UserRole, Long> {
    /*
     * 获得用户对应的用户角色关系
     * */
    @Query(value = "select * from userrole where user_id = :userId", nativeQuery = true)
    List<UserRole> findByUserId(@Param("userId") long userId);
}
