package com.oyy.service;

import com.oyy.mapper.RoleMapper;
import com.oyy.mapper.UserMapper;
import com.oyy.pojo.Role;
import com.oyy.pojo.User;
import com.oyy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Iterator;
import java.util.List;

public class CountScoreService
{
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Role> selectAll()
    {
        SqlSession sqlSession = factory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roles = mapper.selectAll();
        sqlSession.close();
        return roles;
    }
    public void update(Role role){
        SqlSession sqlSession = factory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        mapper.update(role);
        sqlSession.commit();
        sqlSession.close();
    }
    public void returnTozero(){
        for (int i=1;i<=3;i++)
        {
            Role role = new Role();
            if(i==1)
                role.setUsername("阳爷");
            if(i==2)
                role.setUsername("欧阳雪");
            if(i==3)
                role.setUsername("贺震");
            role.setScore(0);
            update(role);
        }
    }

    public List<Role> countScoreService(int num, String host, int win)
    {
        int dis;
        List<Role> roles = selectAll();
        //计算输赢分数差值
        Iterator<Role> it = roles.iterator();

        while (it.hasNext()) {

            Role role = it.next();
            if (role.getUsername().equals(host))
                dis = 1;
            else
                dis = 0;

            if (dis == 0 & win == 0) {
                role.setScore(role.getScore() + num);
            }
            if (dis == 1 & win == 0) {
                role.setScore(role.getScore() - 2 * num);
            }
            if (dis == 0 & win == 1) {
                role.setScore(role.getScore() - num);
            }
            if (dis == 1 & win == 1) {
                role.setScore(role.getScore() + 2 * num);
            }
            update(role);
        }
        return roles;
    }
}

