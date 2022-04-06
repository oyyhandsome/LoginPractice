package com.oyy.web;

import com.oyy.pojo.User;
import com.oyy.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet
{
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //设置cookie来完成记住我
        String remember = request.getParameter("remember");


        User user = service.select(username, password);



        if (user != null) {
            //跳转到品牌界面
            if("1".equals(remember))
            {
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);

                response.addCookie(c_password);
                response.addCookie(c_username);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            //重定向请求
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");
        } else {
            //跳转回登陆界面，并显示错误信息
            request.setAttribute("login_msg", "用户名或密码错误");

            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}
