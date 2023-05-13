package com.bit.model.service;

import com.bit.vo.AjaxAppMemberBean;

import java.util.List;

public interface AjaxAppService {
    public void insetAjaxMember(AjaxAppMemberBean bean);
    public List<AjaxAppMemberBean> selectAjaxAppMember();



}
