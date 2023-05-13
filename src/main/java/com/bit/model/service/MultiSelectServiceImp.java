package com.bit.model.service;

import com.bit.model.dao.MultiSelectDao;
import com.bit.model.dao.MultiSelectDaoImp;
import com.bit.vo.BoardAppVO;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MultiSelectServiceImp implements MultiSelectService {
    private static MultiSelectService multiSelectService = new MultiSelectServiceImp();

    @Override
    public List<Object> selectEmp(Hashtable<String, Object> map) {
        return MultiSelectDaoImp.getMultiSelectDao().selectEmp(map);   //Dao 부름
    }

    public static MultiSelectService getMultiSelectService() {
        return multiSelectService;
    }

    @Override
    public String getIdCheck(String id) {
        // TODO Auto-generated method stub
        return MultiSelectDaoImp.getMultiSelectDao().getIdCheck(id);
    }

    @Override
    public void insertBoard(BoardAppVO vo) {
        MultiSelectDaoImp.getMultiSelectDao().insertBoard(vo);
    }

    @Override
    public List<BoardAppVO> selectAll(HashMap<String, Object> map) {
        return MultiSelectDaoImp.getMultiSelectDao().selectAll(map);
    }
    @Override
    public void updateHit(int no) {
        // TODO Auto-generated method stub
        MultiSelectDaoImp.getMultiSelectDao().updateHit(no);

    }
    @Override
    public Object selectInfo(int no) {
        // TODO Auto-generated method stub
        return  MultiSelectDaoImp.getMultiSelectDao().selectInfo(no);
    }
    @Override
    public void updateBoard(BoardAppVO vo) {
        // TODO Auto-generated method stub

    }
    @Override
    public void deleteBoard(int no) {
        // TODO Auto-generated method stub

    }

    @Override
    public int totalCount(HashMap<String, Object> map) {
        return MultiSelectDaoImp.getMultiSelectDao().totalCount(map);
    }

    @Override
    public String getPassCheck(String pass) {
        // TODO Auto-generated method stub
        return MultiSelectDaoImp.getMultiSelectDao().getPassCheck(pass);
    }
}
