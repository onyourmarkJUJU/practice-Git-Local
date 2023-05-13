<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>관리자</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=10" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="copyright" content="Copyright 2009 @ high1 all rights reserved" />
<link href="${pageContext.request.contextPath}/css/contents.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<!-- 모델1 모델2 -->
<script type="text/javascript">
   $(function(){
	  $("img#btnSubmit").click(function(){
		  if($("input[name='id']").val().length==0||$("input[type='password']").val().length==0){
			  alert('ID OR PASS CHECK!');
			  $("input[name='id']").val('');
			  $("input[type='password']").val('');
			  $("input[name='id']").focus();
			  return false;			  
		  }else{
			 //$("form[name='login']").submit();
			 $.ajax({
				url:'${pageContext.request.contextPath}/loginSelect.do',
				type:'POST',
				data:{"cmd":'loginSelect',"id":$("input#user_id").val(),"pass":$("input#user_passwd").val()},
				success:function(data){
					if(data.trim()=='T') {
                     document.location.href = '${pageContext.request.contextPath}/listSelect.do?cmd=listSelect';
                    } else {
                     $("dt#show").html("<font color='red'> Check </font>");
                     $("input[name='id']").val('');
                     $("input[name='pass']").val('');
                     $("input[name='id']").focus();
                    }
				},error:function(){
					console.log('error');
				}
			 });
		  }
	  });
   });
</script>
</head>
<body>
<form name="login" method="post" action="#">
 <div id="loginWrapper">
  <div class="loginForm">
   <fieldset>
    <legend>관리자 시스템 로그인</legend>
    <dl>
     <dt id="show"></dt>
     <dt><img src="${pageContext.request.contextPath}/img/common/th_id.gif" alt="아이디" /></dt>
     <dd><input type="text" name="id" class="text" id="user_id" /></dd>

     <dt><img src="${pageContext.request.contextPath}/img/common/th_pw.gif" alt="비밀번호" /></dt>
     <dd><input type="password" name="pass" class="text" id="user_passwd" /></dd>
    </dl>
    <div class="btn">
     <img id="btnSubmit" src="${pageContext.request.contextPath}/img/button/btn_login.gif" alt="LOGIN" title="LOGIN"  />
    </div>
    
    <div class="saveId"><input type="checkbox" id="checker" name="checker" /> 
     <img src="${pageContext.request.contextPath}/img/common/save_id.gif" alt="아이디 저장" />
    </div>
   </fieldset>
  </div>
 </div>
</form>
</body>
</html>