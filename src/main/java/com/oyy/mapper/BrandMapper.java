package com.oyy.mapper;

import com.oyy.pojo.Brand;


import org.apache.ibatis.annotations.*;

import java.util.List;
/*
* mapper映射类
* */
public interface BrandMapper
{
    /*
    * 查询所有
    * */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();
    /*
    * 添加数据
    * */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void insert(Brand brand);
    /*
    * 根据Id回显数据
    * */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(Integer id);

    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered}," +
            "description = #{description},status = #{status} where id =#{id} " )
    void  update(Brand brand);

    /*
    * 删除表
    * */
    @Delete("delete from tb_brand where id = #{id}")
    void delete(Integer id);
}
