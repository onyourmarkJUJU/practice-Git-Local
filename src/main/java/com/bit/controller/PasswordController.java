package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PasswordController implements ProcessController {
    private String path;
    private boolean redirect;

    public PasswordController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        //BL수행
        System.out.println("PasswordController");
        String pass = request.getParameter("password");   //passCheck.jsp에서 L26에서 data 받는 게 key | value 형태 -> key값 받아야 됨 (parameter 이름 맞춰줘야 함)
        System.out.println(pass);

        String dbPass=MultiSelectServiceImp.getMultiSelectService().getPassCheck(pass);

        if(dbPass != null && dbPass.equals(pass)) {
            request.getSession().setMaxInactiveInterval(60*10);
            request.setAttribute("state", "T");
        } else {
//            path="jsp/adminLogin.jsp";
            request.setAttribute("state", "F");
        }
        path="jsp/AjaxLoginView.jsp";
        redirect=false;

        return new ForWardController(path, redirect);
    }
}
