package com.bit.model.service;

import com.bit.vo.BoardAppVO;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public interface MultiSelectService {
    public List<Object> selectEmp(Hashtable<String, Object> map);
    public String getIdCheck(String id);//로그인 체크 메소드
    public void insertBoard(BoardAppVO vo);
    public List<BoardAppVO> selectAll(HashMap<String, Object> map);   //key | value
    public void updateHit(int no);
    public Object selectInfo(int no);
    public void updateBoard(BoardAppVO vo);
    public void deleteBoard(int no);
    public int totalCount(HashMap<String, Object> map);

    public String getPassCheck(String pass);
}
