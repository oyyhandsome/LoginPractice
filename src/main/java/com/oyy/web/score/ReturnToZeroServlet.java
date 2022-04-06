package com.oyy.web.score;

import com.oyy.service.CountScoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/returnToZeroServlet")
public class ReturnToZeroServlet extends HttpServlet
{
    private CountScoreService service = new CountScoreService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        service.returnTozero();
        request.getRequestDispatcher("/selectAllScoreServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        this.doGet(request, response);
    }
}
