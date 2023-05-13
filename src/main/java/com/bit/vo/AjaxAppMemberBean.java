package com.bit.vo;

public class AjaxAppMemberBean {
    private int no;
    private String name;
    private String hobby;
    private String today;

    public AjaxAppMemberBean() {
        super();
    }
    /*public AjaxAppMemberBean(String name, String) {
        super();
    }*/

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }


}
