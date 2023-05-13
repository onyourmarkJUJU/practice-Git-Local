package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoController implements ProcessController {
    private String path;
    private boolean redirect;

    public InfoController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("InfoController");

        int no=Integer.parseInt(request.getParameter("no"));

        String job=request.getParameter("job");
        System.out.println(no+" "+job);
        path="info.do?cmd=info&job="+job+"&no="+no;
        if(job!=null &&job.equals("info")) {
            path="jsp/info.jsp";
        }
        request.setAttribute("info", MultiSelectServiceImp.getMultiSelectService().selectInfo(no));
        return new ForWardController(path, redirect);
    }
}
