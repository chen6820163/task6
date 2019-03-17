<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>


<main>
    <head >
        <title>添加学生信息</title>

        <style>
            label {display:inline-block; width: 10em; margin-right: 1em; text-align: right; }
        </style>
    </head>
<h2>${msg1}</h2>
<h2>${msg2}</h2>
<div align="center">
    <a href="${pageContext.request.contextPath}/task2/index" methods="get">首页</a>
</div>

<div align="center">
<form action="task2/student" method="post" id="form1">
    <label>学员姓名：</label><input type="text" name="name" id="name"  required=""
                             oninvalid="this.setCustomValidity('请输入姓名')" oninput="setCustomValidity('')"><br>
    <label>职位：</label><input type="text" name="career" id="career"  ><br>
    <label>薪水：</label><input type="text" name="salary" id="salary"><br>
    <label>职业简介：</label><input type="text" name="careerBrief" id="careerBrief"><br>>
    &Tab;<label></label><input type="submit" value="提交" ><br>
</form>
</div>
</main>

