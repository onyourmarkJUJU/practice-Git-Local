package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.service.MultiSelectServiceImp;

public class HitController implements ProcessController{
    private String path;
    private boolean redirect;


    public HitController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }


    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        System.out.println("HitController");

        int no=Integer.parseInt(request.getParameter("no"));

        String job=request.getParameter("job");
        System.out.println(no+" "+job);
        path="info.do?cmd=info&job="+job+"&no="+no;
        MultiSelectServiceImp.getMultiSelectService().updateHit(no);
        return new ForWardController(path, redirect);
    }
}

