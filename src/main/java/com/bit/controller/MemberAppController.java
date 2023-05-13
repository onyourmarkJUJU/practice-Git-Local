package com.bit.controller;

import com.bit.model.service.AjaxAppServiceImp;
import com.bit.vo.AjaxAppMemberBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberAppController implements ProcessController {
    private String path;
    private boolean redirect;

    public MemberAppController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String hobby = request.getParameter("hobby");
        String state = request.getParameter("state");

        System.out.println("name +" + name + "+ hobby" + hobby);

        //Service 통해 Dao 부르기
        if(state.equals("add")) {
            //dao.insert()
//            AjaxAppServiceImp.getAjaxAppService().insetAjaxMember(new AjaxAppMemberBean(name, ));
        } else if (state.equals("mod")) {
            //dao.update()
        } else if (state.equals("del")) {
            //dao.delete()
        }
        request.setAttribute("ajaxList", "dao.selectAllMember()");

        return new ForWardController(path, redirect);
    }
}
