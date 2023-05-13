package com.bit.model.dao;

import com.bit.vo.AjaxAppMemberBean;

import java.util.List;

public class AjaxAppDaoImp implements AjaxAppDao {
    private static AjaxAppDaoImp ajaxAppDao;

    public static AjaxAppDaoImp getAjaxAppDao() {
        return ajaxAppDao = (ajaxAppDao == null) ? new AjaxAppDaoImp() : ajaxAppDao;
    }

    @Override
    public void insetAjaxMember(AjaxAppMemberBean bean) {

    }

    @Override
    public List<AjaxAppMemberBean> selectAjaxAppMember() {
        return null;
    }
}
