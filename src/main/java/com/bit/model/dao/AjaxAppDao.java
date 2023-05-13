package com.bit.model.dao;

import com.bit.vo.AjaxAppMemberBean;

import java.util.List;

public interface AjaxAppDao {
    public void insetAjaxMember(AjaxAppMemberBean bean);
    public List<AjaxAppMemberBean> selectAjaxAppMember();
}
