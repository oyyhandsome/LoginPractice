package com.oyy.mapper;

import com.oyy.pojo.Role;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper
{
    @Select("select  * from score")
    List<Role> selectAll();

    @Update("update score set score = #{score} where username  = #{username} " )
    void update(Role role);
}
