package com.netease.zzw.shopping.dao;

import com.netease.zzw.shopping.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    /*
     * 获取角色id对应的角色
     * */
    @Query(value = "select * from Role where id in (:roleIdList)", nativeQuery = true)
    List<Role> getRoleByIds(@Param("roleIdList") List<Long> roleIdList);
}
