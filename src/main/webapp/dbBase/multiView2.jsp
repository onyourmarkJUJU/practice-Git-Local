<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script type="text/javascript">
        $(function () {

        });
    </script>
</head>
<body>
<div class="container">
    <h2>Contextual Classes</h2>
    <p>Contextual classes can be used to color the table, table rows or table cells. The classes that can be used are: .table-primary, .table-success, .table-info, .table-warning, .table-danger, .table-active, .table-secondary, .table-light and .table-dark:</p>
    <table class="table">
        <thead>
        <tr>
            <c:forEach var="entry" items="${list[0]}">
                <th>${entry.key}</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="i" items="${list}" varStatus="cnt">
            <c:choose>
                <c:when test="${cnt.count mod 2 eq 0 }">
                    <tr class="table-success">
                        <c:forEach var="entry" items="${i}">
                            <th>${entry.value }</th>
                        </c:forEach>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr class="table-primary">
                        <c:forEach var="entry" items="${i}">
                            <th>${entry.value }</th>
                        </c:forEach>
                    </tr>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>