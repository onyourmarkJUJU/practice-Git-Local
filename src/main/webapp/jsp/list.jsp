<%--
<%@ page import="com.bit.dao.EmpDao" %>
<%@ page import="com.bit.model.EmpBean" %>
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>관리자</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=10" />
<meta http-equiv="imagetoolbar" content="no" />
<link href="${pageContext.request.contextPath}/css/contents.css" rel="stylesheet" type="text/css" />
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$(function(){
			$("span#search a").click(function(){
				if($("select#query").val()=='0'|| $("input#data").val().length==0) {
					alert('Search KeyWord...');
					$("select#query").prop("selectedIndex",0);
					$("input#data").val('');
					return false;
				}
				$("form").submit();
			});
		});
	</script>
	<%--<%
		String id = (String)session.getAttribute("id");

		if(id == null)
			response.sendRedirect("adminLogin.jsp");

		EmpDao dao = EmpDao.getInstance();
		List<EmpBean> list = dao.selectEmpList();
	%>--%>
</head>
<body >
<%--${empList}--%>
	<div id="wrapper">
		<div id="header">
				<div class="topInfoWrap">
					<div class="topInfoArea clfix">
						<div class="loginWrap">
							<span class="fir">2022.05.17</span>
							<span>13:30:22</span>
							<span><em>000님</em> 좋은 하루 되세요</span>
							<a href="" class="btnLogout"><img src="${pageContext.request.contextPath}/img/common/btn_logout.gif" alt="로그아웃" /></a>
						</div>
					</div>
				</div>
				<div class="gnbSubWrap">
					
				</div>
			</div>
		<div id="container">
			<div id="contentsWrap" class="contentsWrap">
				<div class="contents">
					<h1 class="title">게시판 리스트</h1>
					<div class="btnSet clfix mgb15">
						<span class="fr">
							<span class="button" id="search"><a href="#">검색</a></span>
							<span class="button"><a href="${pageContext.request.contextPath}/jsp/edit.jsp">글쓰기</a></span>
						</span>
					</div>

					<form action="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect" method="post">
					<table class="bbsWrite mgb35">
						<caption></caption>
						<colgroup>
							<col width="95" />
							<col width="395" />
							<col width="95" />
							<col />
						</colgroup>
						<tbody>
						<tr>
							<th>검색</th>
							<td>
								<select id="query" name="query">
									<option value="empty">선택하세요</option>
									<option value="title">TITLE</option>
									<option value="writer">WRITER</option>
									<option value="regdate">REGDATE</option>
								</select>
								<input type="text" name="data" class="inputText" size="30" id="data" value="${data}"/>
							</td>
						</tr>
						</tbody>
					</table>
					</form>

					<table class="bbsList">
						<colgroup>
							<col width="150" />
							<col width="150" />
							<col width="150" />
							<col width="150" />
							<col width="150" />
							<col width="150" />
						</colgroup>
						<thead>
						<tr>
							<th scope="col">IMG</th>
							<th scope="col">No</th>
<%--							<th scope="col">ID</th>--%>
							<th scope="col" class="fir">TITLE</th>
							<th scope="col">WRITER</th>
<%--							<th scope="col">PASSWORD</th>--%>
<%--							<th scope="col">CONTENTS</th>--%>
							<th scope="col">HIT</th>
<%--							<th scope="col">FILENAME</th>--%>
							<th scope="col">REGDATE</th>
						</tr>
						</thead>

<%--						VALUES(#{title}, #{writer}, #{password}, #{contents}, #{id}, 0, #{fileName}, now())--%>
						<tbody>
						<c:forEach var="i" items="${list}">
							<tr>
								<td> <img src="${pageContext.request.contextPath}/upload/${i.fileName}" alt="이미지" width="50px" height="50px"/> </td>
								<td> <a href="${pageContext.request.contextPath}/hit.do?cmd=hit&no=${i.no}&job=info">${i.no}</a></td>
<%--								<td> ${i.id} </td>--%>
								<td> ${i.title} </td>
								<td> ${i.writer} </td>
<%--								<td> ${i.password} </td>--%>
<%--								<td> ${i.contents} </td>--%>
								<td> ${i.hit} </td>
<%--								<td> ${i.fileName} </td>--%>
								<td> ${i.regdate} </td>
							</tr>
						</c:forEach>
						</tbody>

						<%--<tbody>
						<% for(int i =0; i < list.size(); i++) {
						%>
							<tr>
								<td class="fir"> <%= list.get(i).getEmpno()%></td>
								<td class="fir"> <%= list.get(i).getEname()%></td>
								<td class="fir"> <%= list.get(i).getSal()%></td>
								<td class="fir"> <%= list.get(i).getMgr()%></td>
								<td class="fir"> <%= list.get(i).getComm()%></td>
								<td class="fir"> <%= list.get(i).getHiredate()%></td>
								<td class="fir"> <%= list.get(i).getDeptno()%></td>
							</tr>
						<%
							}
						%>
						</tbody>--%>
					</table>

					<div class="paging">
						<a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_first.gif" alt="처음페이지" /></a>
						<a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_prev.gif" alt="이전" /></a>

						<span>
								<c:set var="count" value="${totalNum}"></c:set>
								<c:set var="perPage" value ="10"></c:set>
								<c:set var="currentPage" value="${currentPagenum}"></c:set>
								<c:set var="totalstrPage" value = "${Math.floor((count-1)/perPage+1)}"></c:set>
								<fmt:parseNumber var="totalNumPage" type="number" value="${totalstrPage}" />
								<c:set var="totalPage" value="${totalNumPage}"></c:set>

								<c:choose>
									<c:when test="${currentPage >5}">
										<c:set var="startPage" value="${currentPage-5}"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="startPage" value="1"></c:set>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${totalPage<=10}">
										<c:set var="endPage" value="${totalPage}"></c:set>
									</c:when>
									<c:otherwise>
										<c:set var="endPage" value="${startPage+9}"></c:set>

										<c:if test="${endPage>totalPage}">
											<c:set var="endPage" value="${totalPage}"></c:set>
											<c:set var="startPage" value="${endPage-9}"></c:set>
										</c:if>
									</c:otherwise>
								</c:choose>


								<c:forEach begin="${startPage}" end="${endPage}" var="i">
									<c:choose>
										<c:when test="${i==currentPage}">
											<a href="${pageContext.request.contextPath}/list.do?cmd=listSelect&query=${query}&data=${data}&currentPagenum=${i}"><b>${i}</b></a>
										</c:when>
										<c:otherwise>
											<a href="${pageContext.request.contextPath}/list.do?cmd=listSelect&query=${query}&data=${data}&currentPagenum=${i}">${i}</a>
										</c:otherwise>
									</c:choose>

								</c:forEach>

							  </span>


						<a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_next.gif" alt="다음" /></a>
						<a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_last.gif" alt="마지막페이지" /></a>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
