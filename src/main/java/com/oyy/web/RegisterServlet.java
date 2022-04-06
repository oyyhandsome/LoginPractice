package com.oyy.web;

import com.oyy.pojo.User;
import com.oyy.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet
{
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取用户输入的验证码
        String userInput_checkCode = request.getParameter("checkCode");

        //从session获取生成的验证码
        HttpSession session = request.getSession();
        String auto_checkCode = (String) session.getAttribute("checkCodes");

        //判断验证码是否输入正确
        if(!auto_checkCode.equalsIgnoreCase(userInput_checkCode)){
            //不正确，直接返回
            request.setAttribute("register_msg_check","验证码输入错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        User user =new User();
        user.setPassword(password);
        user.setUsername(username);
        //获取用户名是否唯一，b值为true为空
        boolean b = service.register(user);

        if(b)
        {
            //跳回登陆界面
            request.setAttribute("register_msg_success","注册成功，请登陆");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else{
            //用户名重复
            request.setAttribute("register_msg_repeat","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}
