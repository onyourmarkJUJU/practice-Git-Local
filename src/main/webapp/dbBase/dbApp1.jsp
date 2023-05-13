<%@ page import="com.bit.conf.SqlSessionManager" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
Created by IntelliJ IDEA.
  User: 금정산1_PC20
  Date: 2023-05-03
  Time: PM 5:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    SqlSessionFactory sessionFactory = SqlSessionManager.getSqlSessionFactory();
    SqlSession sqlSession = sessionFactory.openSession();
%>
EMP<%=sqlSession.selectList("com.bit.vo.EMP")%>
</body>
</html>
