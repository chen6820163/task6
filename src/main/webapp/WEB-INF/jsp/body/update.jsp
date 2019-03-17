<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/29 0029
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>
    <title>Title</title>
    <style>
        label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
    </style>
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
        setTimeout(function () {
            document.getElementById("h1").style.display="none";
        },3000);
    </script>
</head>
<main>
<br>
    <div id="h1" align="center"><h1 >${msg1}${msg2}</h1></div>
<br>
<div align="center">
    <a href="/task2/index" methods="get">首页</a>
</div>

<br>
<div align="center">
    <c:if test="${!empty s}">
    <form action="${pageContext.request.contextPath}/task2/student" method="post" >
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="id" value="${s.id}"/>
        <input type="hidden" name="createAt" value="${s.createAt}">
        <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>"/>

        <label>姓名：</label><input type="text" name="name" value="${s.name}" required=""><br>
        <label>职位：</label><input type="text" name="career" value="${s.career}" required=""><br>
        <label>薪水：</label><input type="text" name="salary" value="${s.salary}" required=""><br>
        <label>职业简介：</label><input type="text" name="careerBrief" value="${s.careerBrief}" required=""><br>
        &Tab;<label></label><input type="submit" value="确认修改" ><br>
    </form>
    </c:if>
    <c:if test="${!empty s1}">
        <form action="${pageContext.request.contextPath}/task2/student" method="post" >
            <input type="hidden" name="_method" value="PUT">
            <input type="hidden" name="id" value="${s1.id}"/>
            <input type="hidden" name="createAt" value="${s1.createAt}">
            <input type="hidden" name="updateAt" value="<%=System.currentTimeMillis()%>"/>

            <label>姓名：</label><input type="text" name="name" value="${s1.name}" required=""><br>
            <label>职位：</label><input type="text" name="career" value="${s1.career}" required=""><br>
            <label>薪水：</label><input type="text" name="salary" value="${s1.salary}" required=""><br>
            <label>职业简介：</label><input type="text" name="careerBrief" value="${s1.careerBrief}" required=""><br>
            &Tab;<label></label><input type="submit" value="确认修改" ><br>
        </form>
    </c:if>
</div>


</main>
