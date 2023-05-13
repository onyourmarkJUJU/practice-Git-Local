<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("input[type='button']").click(function () {
                $.ajax({
                    url: '${pageContext.request.contextPath}/memberApp.do?cmd=memberApp&state=' + this.id,
                    type: 'POST',
                    // 방법1 -> data:{name:$("input#Name").val(), hobby:$("input#hobby").val()},
                    // 방법2 -> data:$("form#memberFrm").serialize(),
                    data:$("form#memberFrm").serialize(),
                    success: function (value) {
                        console.log(value);
                    },
                    error: function () {
                        alert('error');
                    }
                });
            });
        });
    </script>
</head>
<body>
 <form method="post" id="memberFrm">
     <input type="text" name="name">
     <input type="text" name="hobby">
     <input type="button" id="add" value="Add">
     <input type="button" id="mod" value="Mod">
     <input type="button" id="del" value="Del">
 </form>
<div> List </div>
</body>
</html>
