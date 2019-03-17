
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <header>
    <div class="container logo">
    <span>客服热线：010-594-78634</span>
    <div class="img-amuse">
    <img src="/img/task8.2.png" height="24" width="25"/>
    <img src="/img/task8.1.png" height="24" width="25"/>
    <img src="/img/task8.png" height="24" width="25"/>
    <c:if test="${sessionScope.get('username') == null}">
    <span class="header-dot-333">|</span>
    <a style="color: #000000" href="/a/u/gologin">登录</a>
    <span class="header-dot-333">|</span>
    <a style="color: #000000" href="/a/u/goreg">注册</a>
    </c:if>
    <c:if test="${sessionScope.get('username') != null}">
        <span class="header-dot-333">|</span>
        <span style="color: #000000">欢迎你,${sessionScope.get('username')}</span>
        <span class="header-dot-333">|</span>
        <a style="color: #000000" href="/u/loginOut">退出</a>
    </c:if>
    </div>
    </div>
    <div class="center-box">
    <div class="container ">
    <div class="nav">
    <input type='checkbox' id='sidemenu'>
    <img  class="img-jinshu" src="/img/task8.3.png" height="50" width="107"/>
    <div id='wrap-box'>
    <label  for='sidemenu'>
    <img  class="flexible " src="/img/task13 (1).png" height="30" width="34"/></label>
    </div>

    <ul  class="topnav">
    <li><a href="${pageContext.request.contextPath}/a/u/home">首页</a></li>
    <li><a href="${pageContext.request.contextPath}/u/career">职业</a></li>
    <li><a href="${pageContext.request.contextPath}/u/recommend">推荐</a></li>
    <li><a  href="${pageContext.request.contextPath}/task2/index">列表</a></li>
    </ul>
    </div>
    </div>
    </div>
    </header>
