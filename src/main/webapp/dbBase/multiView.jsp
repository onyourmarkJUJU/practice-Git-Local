<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <%--<style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>--%>
</head>
<body>
<%--<h1> MVIEW </h1>
${list}--%>

<%--<h2>HTML Table</h2>

<table>
    <tr>
        <th>Company</th>
        <th>Contact</th>
        <th>Country</th>
    </tr>
    <tr>
        <td>Alfreds Futterkiste</td>
        <td>Maria Anders</td>
        <td>Germany</td>
    </tr>
    <tr>
        <td>Centro comercial Moctezuma</td>
        <td>Francisco Chang</td>
        <td>Mexico</td>
    </tr>
    <tr>
        <td>Ernst Handel</td>
        <td>Roland Mendel</td>
        <td>Austria</td>
    </tr>
    <tr>
        <td>Island Trading</td>
        <td>Helen Bennett</td>
        <td>UK</td>
    </tr>
    <tr>
        <td>Laughing Bacchus Winecellars</td>
        <td>Yoshi Tannamuri</td>
        <td>Canada</td>
    </tr>
    <tr>
        <td>Magazzini Alimentari Riuniti</td>
        <td>Giovanni Rovelli</td>
        <td>Italy</td>
    </tr>--%>

<%--<div class="container">
    <h2>Dark Striped Table</h2>
    <p>Combine .table-dark and .table-striped to create a dark, striped table:</p>
    <table class="table table-dark table-striped w-100">
        <thead>
        <tr>
            <th>NO</th>
            <th>EMPLOYEE_ID</th>
            <th>FIRST_NAME</th>
            <th>LAST_NAME</th>
            <th>EMAIL</th>
            <th>PHONE_NUMBER</th>
            <th>HIRE_DATE</th>
            <th>JOB_ID</th>
            <th>SALARY</th>
            <th>COMMISSION_PCT</th>
            <th>MANAGER_ID</th>
            <th>DEPARTMENT_ID</th>
        </tr>
        </thead>
        <tbody>--%>
        <!--     private int employee_id;
            private String first_name;
            private String last_name;
            private String email;
            private String phone_number;
            private String hire_date;
            private String job_id;
            private int salary;
            private int commission_pct;
            private int manager_id;
            private int department_id; -->
<%--        <c:forEach var="i" items="${list}" varStatus="cnt">
            <tr>
                <th>${cnt.count}</th>
                <th>${i.employee_id }</th>
                <th>${i.first_name }</th>
                <th>${i.last_name }</th>
                <th>${i.email }</th>
                <th>${i.phone_number }</th>
                <th>${i.hire_date }</th>
                <th>${i.job_id }</th>
                <th>${i.salary }</th>
                <th>${i.commission_pct }</th>
                <th>${i.manager_id }</th>
                <th>${i.department_id }</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>--%>

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
        <c:forEach var="i" items="${list}">
            <tr>
                <c:forEach var="entry" items="${i}">
                    <th>${entry.value }</th>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>

</table>
</body>
</html>
