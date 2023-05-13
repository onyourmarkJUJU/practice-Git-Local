package com.bit.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servlet", urlPatterns = {"*.do"})
public class DispatcherServlet extends HttpServlet {
    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }*/

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cmd = request.getParameter("cmd");
        ProcessController pc = MapperServlet.getMapper(cmd);
        ForWardController fc = pc.execute(request, response);   //전략 패턴   //DI

        if(fc.isRedirect()) {   //path
            response.sendRedirect(fc.getPath());
        } else {
            RequestDispatcher rd = request.getRequestDispatcher(fc.getPath());
            rd.forward(request, response);   //url 안바뀜    // /list.do
        }
    }
}