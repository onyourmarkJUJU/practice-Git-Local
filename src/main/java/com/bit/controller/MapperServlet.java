package com.bit.controller;

public class MapperServlet {

    public static ProcessController getMapper(String cmd) {
        ProcessController processController=null;

        if(cmd.equalsIgnoreCase("multi")) {
            processController = new MultiSelectController("dbBase/multiView2.jsp", false);
        }
        if(cmd.equalsIgnoreCase("loginSelect")) {
            processController=new LoginSelectController("", true);
        }
        if(cmd.equalsIgnoreCase("listSelect")) {
            processController=new MultiSelectController("jsp/list.jsp", false);    //리다이렉트면 true, 디스패처면 false
        }
        if(cmd.equals("insertBoard")) {
            processController=new InsertController("listSelect.do?cmd=listSelect", true);
        }
        if(cmd.equals("hit")) {
            processController=new HitController("",true);
        }
        if(cmd.equals("info")) {
            processController=new InfoController("",false);
        }
        if(cmd.equalsIgnoreCase("passSelect")) {
            processController=new PasswordController("", true);
        }

        return processController;
    }

}
