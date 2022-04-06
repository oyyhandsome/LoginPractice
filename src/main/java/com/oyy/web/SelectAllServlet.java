package com.oyy.web;

import com.oyy.pojo.Brand;
import com.oyy.pojo.User;
import com.oyy.service.BrandService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/*
* 添加一个servlet来响应请求，创建一个service对象，获取brands，然后将brands设置进域，再转发请求給jsp，
* */
@WebServlet( urlPatterns = "/selectAllServlet")
public class SelectAllServlet extends HttpServlet
{
    //构造service类对象
    private BrandService service = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    //service类来完成对mapper的获取并返回一个brands，
        List<Brand> brands = service.selectAll();

    //将brands设置到request的域中
        request.setAttribute("brands",brands);



        //request请求转发

        request.getRequestDispatcher("/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}
