package com.bit.model.service;

import com.bit.model.dao.AjaxAppDaoImp;
import com.bit.vo.AjaxAppMemberBean;

import java.util.List;

public class AjaxAppServiceImp implements AjaxAppService {
    private static AjaxAppService ajaxAppService;

    public static AjaxAppService getAjaxAppService() {
        if(ajaxAppService == null)
            return new AjaxAppServiceImp();
            return ajaxAppService;
    }

    @Override
    public void insetAjaxMember(AjaxAppMemberBean bean) {
        AjaxAppDaoImp.getAjaxAppDao().insetAjaxMember(bean);
    }

    @Override
    public List<AjaxAppMemberBean> selectAjaxAppMember() {
        return null;
    }
}
