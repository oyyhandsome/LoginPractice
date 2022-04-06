package com.oyy.service;

import com.oyy.mapper.BrandMapper;
import com.oyy.pojo.Brand;
import com.oyy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/*
 * 添加service类来完成对mapper的获取并返回一个brands，这是因为有可能多个servlet来调用这个service,如果没有，就只能在每个servlet里面添加service,
 * 这样导致了代码重复
 * */
public class BrandService
{
    //通过SqlSessionFactoryUtils类来获取SqlSessionFactory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll()
    {

        //获取SqlSession对象，mybatis提供的类，照着写
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //获取brands
        List<Brand> brands = mapper.selectAll();
        //释放资源
        sqlSession.close();

        return brands;
    }

    public void insert(Brand brand)
    {
        //获取SqlSession对象，mybatis提供的类，照着写
        SqlSession sqlSession = factory.openSession();
        //获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.insert(brand);
        sqlSession.commit();

        sqlSession.close();

    }

    public Brand selectById(Integer id)
    {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = mapper.selectById(id);

        sqlSession.close();
        return brand;

    }
    public  void update(Brand brand)
    {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();

    }

    public void delete(Integer id)
    {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
