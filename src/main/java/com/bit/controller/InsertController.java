package com.bit.controller;

import com.bit.model.service.MultiSelectServiceImp;
import com.bit.vo.BoardAppVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class InsertController implements ProcessController {
    private String path;
    private boolean redirect;

    public InsertController(String path, boolean redirect) {
        super();
        this.path = path;
        this.redirect = redirect;
    }


    @Override
    public ForWardController execute(HttpServletRequest request, HttpServletResponse response) {
        //upload,insert
        /*System.out.println("InsertController");
        return new ForWardController(path, redirect);*/

        //upload, insert
        int size = 10*1024*1024;
        String uploadPath = "C:\\dev\\study-java\\jspMyBatis\\src\\main\\webapp\\upload\\";

        try {
            MultipartRequest multi = new MultipartRequest(request, uploadPath, size,"UTF-8", new DefaultFileRenamePolicy());   //똑같은 파일 업로드시 자동으로 변환

            Enumeration e = multi.getFileNames();
            String file = (String) e.nextElement();

            BoardAppVO vo = new BoardAppVO(multi.getParameter("title"),
                    multi.getParameter("writer"),
                    multi.getParameter("password"),
                    multi.getParameter("contents"),
                    multi.getParameter("id"),
                    multi.getOriginalFileName(file));

            System.out.println(vo);

            MultiSelectServiceImp.getMultiSelectService().insertBoard(vo);

/*            String title = request.getParameter("title");
            System.out.println("title = " + title);*/

//            String title = multi.getParameter("title");
//            System.out.println("title: " + title);
//
//            Enumeration e = multi.getFileNames();
//            String file = (String) e.nextElement();
//            System.out.println("file: " + file);
//            String fileFileName = multi.getFilesystemName(file);
//            String originfileName = multi.getOriginalFileName(file);
//
//            System.out.println("fileFileName: " + fileFileName);
//            System.out.println("originfileName: " + originfileName);
//            System.out.println(multi.getContentType(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ForWardController(path, redirect);
    }
}
