package com.oyy.service;

import com.oyy.mapper.UserMapper;
import com.oyy.pojo.User;
import com.oyy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService
{
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /*
     * 给loginServle提供操作数据库服务，调用select()
     * */
    public User select(String username, String password)
    {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.select(username, password);

        sqlSession.close();

        return user;
    }

    public boolean register(User user)
    {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.selectByUsername(user.getUsername());

        if (user1 == null) {
            mapper.add(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return user1 == null;
    }
}

