package com.oyy.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginFilter implements Filter
{
    public void init(FilterConfig config) throws ServletException
    {
    }

    public void destroy()
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException
    {
        HttpServletRequest request1 = (HttpServletRequest) request;
        String[] urls = {"/css/","/imgs/","/login.jsp","register.jsp","/loginServlet","registerServlet","checkCodeServlet"};
        String url = request1.getRequestURL().toString();

        for (String u : urls) {
            if(url.contains(u)){

                chain.doFilter(request,response);

                return;
            }
        }

        HttpSession session = request1.getSession();
        Object user = session.getAttribute("user");

        if(user!=null)
        {
            chain.doFilter(request1, response);

        }
        else{
            request1.setAttribute("login_msg","请先登陆");
            request.getRequestDispatcher("/login.jsp").forward(request1,response);
        }


    }
}
