package com.oyy.web.score;

import com.oyy.pojo.Role;
import com.oyy.service.CountScoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllScoreServlet")
public class SelectAllScoreServlet extends HttpServlet
{
    private CountScoreService service = new CountScoreService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        List<Role> roles = service.selectAll();
        request.setAttribute("roles",roles);
        request.getRequestDispatcher("/score.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}
