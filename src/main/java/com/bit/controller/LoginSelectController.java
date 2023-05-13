package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginSelectController implements ProcessController {
    private String path;
    private boolean redirect;

    public LoginSelectController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        //BL수행
        System.out.println("LoginSelectController");
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        System.out.println(id+" "+pass);

        String dbPass=MultiSelectServiceImp.getMultiSelectService().getIdCheck(id);

        if(dbPass != null && dbPass.equals(pass)) {
            request.getSession().setAttribute("id", id);
            request.getSession().setMaxInactiveInterval(60*10);
            request.setAttribute("state", "T");
            /*request.getSession().setMaxInactiveInterval(30);
            path = "multi.do?cmd=multi&t=employees";
            redirect = true;*/
        } else {
//            path="jsp/adminLogin.jsp";
            request.setAttribute("state", "F");
        }
        path="jsp/AjaxLoginView.jsp";
        redirect=false;

        return new ForWardController(path, redirect);
    }
}
