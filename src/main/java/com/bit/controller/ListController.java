package com.bit.controller;

import com.bit.model.dao.MultiSelectDao;
import com.bit.model.dao.MultiSelectDaoImp;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class ListController implements ProcessController {
    private String path;
    private boolean redirect;
    private PagingComponent pagingComponent=new PagingComponent();

    public ListController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }


    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ListController");
        pagingComponent.pagingCreate(request);
        return new ForWardController(path, redirect);


    }
}
