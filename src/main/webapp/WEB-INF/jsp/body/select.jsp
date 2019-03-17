<%@ page import="org.springframework.ui.Model" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/29 0029
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<head>
    <title>Title</title>
</head>
<main>
<h1>学生信息查询</h1>
<div align="center">
    <a href="/task2/index" methods="get">首页</a>
</div>
<h3>${msg1}</h3><br>
    <table border="">
        <tr>
            <th width="100">学员id</th>
            <th width="131">学员姓名</th>
            <th width="118">职位</th>
            <th width="100">薪水</th>
            <th width="200">职业简介</th>
            <th width="199">注册时间</th>
            <th width="165">更新时间</th>
            <th width="200">操作</th>
        </tr>
        <c:if test="${!empty studentPageInfo}">
            <c:forEach items="${studentPageInfo.list}" var="student" varStatus="status" >
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.career}</td>
                    <td>${student.salary}</td>
                    <td>${student.careerBrief}</td>
                        <%-- 时间戳转化为日期--%>
                    <jsp:useBean id="createAt" class="java.util.Date" scope="page" />
                    <jsp:setProperty property="time" name="createAt" value="${student.createAt}"/>
                    <jsp:useBean id="updateAt" class="java.util.Date" scope="page"/>
                    <jsp:setProperty property="time" name="updateAt" value="${student.updateAt}"/>
                        <%--formDmatDate 格式化日期显示--%>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${createAt}"/></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${updateAt}"/></td>
                    <td>
            <span><a href="${pageContext.request.contextPath}/task2/student/${student.id}">修改</a>
                <a class="delete_href"  href="${pageContext.request.contextPath}/task2/student/${student.id}/${studentPageInfo.pageNum }" >删除</a>
                <%--<input type="submit" value="删除" form="delete"  />--%>
            </span>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <div style="text-align:center">
            <table align="center">
                <tr align="center" bgcolor="#FFFFFF">
                    <td colspan="5">共${studentPageInfo.total }条记录 每页 5 条 第${studentPageInfo.pageNum }/${studentPageInfo.pages}页
                        <a	href="${pageContext.request.contextPath}/task2/index?page=1">首页</a>
                        <c:if test="${studentPageInfo.hasPreviousPage}">
                            <a href="${pageContext.request.contextPath}/task2/index?page=${sstudentPageInfo.prePage }">上一页</a>
                        </c:if>
                        <c:if test="${studentPageInfo.hasNextPage}">
                            <a href="${pageContext.request.contextPath}/task2/index?page=${studentPageInfo.nextPage }">下一页</a>
                        </c:if>
                        <a href="${pageContext.request.contextPath}/task2/index?page=${studentPageInfo.lastPage }">尾页</a>
                    </td>
                </tr>
            </table>
        </div>

    </table>
</main>
