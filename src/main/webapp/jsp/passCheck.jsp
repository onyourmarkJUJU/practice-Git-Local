<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>관리자</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=10"/>
    <meta http-equiv="imagetoolbar" content="no"/>
    <meta name="copyright" content="Copyright 2009 @ high1 all rights reserved"/>
    <link href="${pageContext.request.contextPath}/css/contents.css" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <!-- 모델1 모델2 -->
    <script>
        $(function () {
            $("img#btnSubmit").click(function () {
                if ($("input[type='password']").val().length == 0) {
                    alert('PASS CHECK!');
                    $("input[type='password']").val('');
                    $("input[name='pass']").focus();
                    return false;
                } else {
                    $.ajax({
                        url: '${pageContext.request.contextPath}/passSelect.do',
                        type: 'POST',
                        data: {"cmd": 'passSelect', "password": $("input#user_passwd").val()},
                        success: function (data) {
                            if (data.trim() == 'T') {
                                document.location.href = '${pageContext.request.contextPath}/listSelect.do?cmd=listSelect';
                            } else {
                                alert('PASS CHECK!');
                                $("input[type='password']").val('');
                                $("input[name='pass']").focus();
                            }
                        }, error: function () {
                            console.log('error');
                        }
                    });
                }
            });
        });
    </script>

</head>
<body>
<form name="login" method="post" action="${pageContext.request.contextPath}/passSelect.do?cmd=passSelect">
    <div id="loginWrapper">
        <div class="loginForm">
            <fieldset>
                <legend>관리자 시스템 로그인</legend>
                <dl>
                    <dt id="show"></dt>
                    <dt><img src="${pageContext.request.contextPath}/img/common/th_pw.gif" alt="비밀번호"/></dt>
                    <dd><input type="password" name="pass" class="text" id="user_passwd"/></dd>
                </dl>
                <div class="btn">
                    <img id="btnSubmit" src="${pageContext.request.contextPath}/img/button/btn_login.gif" alt="LOGIN"
                         title="LOGIN"/>
                </div>
            </fieldset>
        </div>
    </div>
</form>
</body>
</html>