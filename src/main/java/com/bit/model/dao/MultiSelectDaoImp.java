package com.bit.model.dao;

import com.bit.conf.SqlSessionManager;
import com.bit.vo.BoardAppVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MultiSelectDaoImp implements MultiSelectDao {
    private static MultiSelectDao multiSelectDao = new MultiSelectDaoImp();
    private SqlSessionFactory sessionFactory = SqlSessionManager.getSqlSessionFactory();


    public static MultiSelectDao getMultiSelectDao() {
        return multiSelectDao;
    }

    @Override
    public List<Object> selectEmp(Hashtable<String, Object> map) {
        SqlSession sqlSession = sessionFactory.openSession();

        List<Object> list = null;
        try {
            list = sqlSession.selectList("com.bit.vo.selectEmp", map);   //"" 이름이 scott.xml에 있는 id가 됨 (namespace는 제외)

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public String getIdCheck(String id) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        String dbPass=null;
        try {
            dbPass=sqlSession.selectOne("com.bit.vo.getIdCheck",id);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return dbPass;
    }

    @Override
    public void insertBoard(BoardAppVO vo) {
        SqlSession sqlSession = sessionFactory.openSession();

        try {
            sqlSession.insert("com.bit.vo.insertBoard", vo);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public List<BoardAppVO> selectAll(HashMap<String, Object> map) {
        SqlSession sqlSession=sessionFactory.openSession();
        List<BoardAppVO> list=null;
        try {
//            list=sqlSession.selectOne("com.bit.vo.getIdCheck",id);
            list = sqlSession.selectList("com.bit.vo.selectAll", map);
            System.out.println(list);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public void updateHit(int no) {
        SqlSession sqlSession=sessionFactory.openSession();
        try {
            sqlSession.update("com.bit.vo.updateHit",no);
            sqlSession.commit();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    @Override
    public Object selectInfo(int no) {
        return sessionFactory.openSession().selectOne("com.bit.vo.selectInfo",no);
    }

    @Override
    public void updateBoard(BoardAppVO vo) {

    }

    @Override
    public void deleteBoard(int no) {

    }

    @Override
    public int totalCount(HashMap<String, Object> map) {
        // TODO Auto-generated method stub
        return sessionFactory.openSession().selectOne("totalCount",map);
    }

    @Override
    public String getPassCheck(String pass) {
        // TODO Auto-generated method stub
        SqlSession sqlSession=sessionFactory.openSession();
        String dbPass=null;
        try {
            dbPass=sqlSession.selectOne("com.bit.vo.getPassCheck",pass);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return dbPass;
    }
}
