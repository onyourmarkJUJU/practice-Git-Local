package com.bit.controller;

import com.bit.model.service.MultiSelectService;
import com.bit.model.service.MultiSelectServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Hashtable;

public class MultiSelectController implements ProcessController {
    private String path;
    private boolean redirect;
    private MultiSelectService multiSelectService = new MultiSelectServiceImp();

    public MultiSelectController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;

    }

    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        String table=request.getParameter("t");
        
        //mybatis 사용할 파라미터
        HashMap<String, Object> map=new HashMap<String, Object>();
               
        //현재페이지번호, 검색종류, 검색내용 => 검색 기능과 페이징 기능 합쳐서 사용하기 위해서 
        String currentPagenum = request.getParameter("currentPagenum")== null?"1":request.getParameter("currentPagenum");
        String query = request.getParameter("query")== null?"empty" :request.getParameter("query");
        String data = request.getParameter("data")==null?"":request.getParameter("data");
        //Startnum => 페이지별로 가지고 올 게시물 번호 (시작) DB내에서 따로 지정해준 rownumber
        //Endnum => 페이지별로 가지고 올 게시물 번호 (끝)
        int Startnum = ((Integer.parseInt(currentPagenum)-1)*10)+1;
        int Endnum =    (Integer.parseInt(currentPagenum)*10);
        
        //파라미터에 검색종류,검색내용, 시작,끝 번호 넣어줌
        map.put("table", table);
        map.put("query", query);
        map.put("data", data);
        map.put("startnum",Startnum);
        map.put("endnum",Endnum);
        
        //Request attribute에 넣어줌 -> jsp(view)단에서 사용하기 위해서
        //페이지별 게시물리스트 가져오는 곳
        request.setAttribute("list", MultiSelectServiceImp.getMultiSelectService().selectAll(map));
        //전체 게시물 수
        request.setAttribute("totalNum",MultiSelectServiceImp.getMultiSelectService().totalCount(map));
        //내가 선택한 검색종류
        request.setAttribute("query",query);
        //내가 선택한 검색내용
        request.setAttribute("data",data);
        //현재 페이지 번호
        request.setAttribute("currentPagenum",currentPagenum);
        
        //list.jsp로 이동
        return new ForWardController(path, redirect);
    }
}
