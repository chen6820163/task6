<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="/dateConvert" prefix="date"%>
<meta name="viewport"
      content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="/css/14.css">
<link rel="stylesheet" href="/css/1415ku.css">
<main>
    <div class="container">
        <div class="row occupation">
            <p><a href="${pageContext.request.contextPath}/a/u/home">首页</a> &gt;
                <span> 职业</span>
            </p>
        </div>
        <div class="row learning">
            <p>方向：</p>
            <span>全部</span>
            <a href="#ptt"><span>前端开发</span></a>
            <a href="#ptt1"><span>后端开发</span></a>
            <a href="#ptt2"><span>移动开发</span></a>
            <a href="#ptt3"><span>整站开发</span></a>
            <a href="#ptt3"> <span>运营维护</span></a>
        </div>

        <div class="row front-end-det-dir">
            <p id="ptt">前端开发方向</p>
        </div>
        <div class="row">
            <c:forEach items="${careers}" var="career"  >
                <c:if test="${career.careerType == '前端开发'}">
            <div class=" col-xs-12 col-md-6 col-lg-4 now">
                <div class="wrapper">
                    <div class="box gird-one">
                        <img src="${career.headImg}" height="139" width="139"/>
                    </div>
                    <div class="box gird-two">
                        <p class="ios-box">${career.name}</p>
                        <p>${career.careerBrief}
                        </p>
                    </div>
                    <div class="box gird-three">
                        门槛&nbsp;&nbsp;&nbsp;&nbsp;
            <c:forEach begin="1" end="${career.threshold}" step="1">
                <img src="/img/xx8.png" height="15" width="16"/>
            </c:forEach>
                    </div>
                    <div class="box gird-four">
                        难易程度&nbsp;&nbsp;&nbsp;&nbsp;
            <c:forEach begin="2" end="${career.satisfaction}" step="1">
                <img src="/img/xx8.png" height="15" width="16"/>
            </c:forEach>
                        <img src="/img/xx8.png" height="15" width="16"/></div>
                    <div class="box gird-five">
                        成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.growthCycle}</span>年
                    </div>
                    <div class="box gird-six">
                        稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.scarcity}</span><span class="time">家公司需要</span>
                    </div>
                    <div class="box gird-seven">
                    </div>
                    <div class="box gird-eight">
                        <span class="time"> 0-1年 <span class="digit">${career.payZeroOne}/月</span></span>
                    </div>
                    <div class="box gird-nine">
                        薪资待遇
                    </div>
                    <div class="box gird-ten">
                        <span class="time">1-3年 <span class="digit">${career.payOneThree}/月</span></span>
                    </div>
                    <div class="box gird-eleven">
                        <span class="time">3-5年 <span  class="digit">${career.payThreeFive}/月</span></span>
                    </div>
                    <div class="box gird-twelve">
                    </div>
                    <div class="box gird-thirteen">
                        <span class="ios-box">有<span class="number-n">${career.num}</span>人在学</span>
                        <div class="ios-box">创建时间：<date:longStr time="${career.createAt}"/>
                            更新时间：
                                <%--通过过jsp:userBean标签引入java.util.Date日期类:--%>
                            <jsp:useBean id="dateValue" class="java.util.Date"/>
                                <%--使用jsp:setProperty标签将时间戳设置到Date的time属性中--%>
                            <jsp:setProperty name="dateValue" property="time" value="${career.updateAt}"/>
                                <%--使用fmt标签转换long格式为设置好的date格式--%>
                            <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm"/></div>
                    </div>

                    <div class="box gird-fifteen">
                        ${career.need}
                    </div>
                    <div class="engineer">
                        <p>${career.careerType}</p>
                        <p>${career.careerDetails}
                        </p>
                    </div>
                </div>
            </div>
                </c:if>
            </c:forEach>

        </div>
        <div class="row front-end-det-dir">
            <p id="ptt1">后端开发方向</p>
        </div>
        <div class="row">
            <c:forEach items="${careers}" var="career" varStatus="status" >
                <c:if test="${career.careerType=='后端开发'}">
                    <div class=" col-xs-12 col-md-6 col-lg-4 now">
                        <div class="wrapper">
                            <div class="box gird-one">
                                <img src="${career.headImg}" height="139" width="139"/>
                            </div>
                            <div class="box gird-two">
                                <p class="ios-box">${career.name}</p>
                                <p>${career.careerBrief}
                                </p>
                            </div>
                            <div class="box gird-three">
                                门槛&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach begin="1" end="${career.threshold}" step="1">
                                    <img src="/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-four">
                                难易程度&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach begin="2" end="${career.satisfaction}" step="1">
                                    <img src="/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                                <img src="/img/xx8.png" height="15" width="16"/></div>
                            <div class="box gird-five">
                                成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.growthCycle}</span>年
                            </div>
                            <div class="box gird-six">
                                稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.scarcity}</span><span class="time">家公司需要</span>
                            </div>
                            <div class="box gird-seven">
                            </div>
                            <div class="box gird-eight">
                                <span class="time"> 0-1年 <span class="digit">${career.payZeroOne}/月</span></span>
                            </div>
                            <div class="box gird-nine">
                                薪资待遇
                            </div>
                            <div class="box gird-ten">
                                <span class="time">1-3年 <span class="digit">${career.payOneThree}/月</span></span>
                            </div>
                            <div class="box gird-eleven">
                                <span class="time">3-5年 <span  class="digit">${career.payThreeFive}/月</span></span>
                            </div>
                            <div class="box gird-twelve">
                            </div>
                            <div class="box gird-thirteen">
                                <span class="ios-box">有<span class="number-n">${career.num}</span>人在学</span>
                            </div>
                            <div class="box gird-fifteen">
                                    ${career.need}
                            </div>
                            <div class="engineer">
                                <p>${career.careerType}</p>
                                <p>${career.careerDetails}
                                </p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="row front-end-det-dir">
            <p id="ptt2">运维方向</p>
        </div>
        <div class="row">
            <c:forEach items="${careers}" var="career" varStatus="status" >
                <c:if test="${career.careerType=='运营维护'}">
                    <div class=" col-xs-12 col-md-6 col-lg-4 now">
                        <div class="wrapper">
                            <div class="box gird-one">
                                <img src="${career.headImg}" height="139" width="139"/>
                            </div>
                            <div class="box gird-two">
                                <p class="ios-box">${career.name}</p>
                                <p>${career.careerBrief}
                                </p>
                            </div>
                            <div class="box gird-three">
                                门槛&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach begin="1" end="${career.threshold}" step="1">
                                    <img src="/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-four">
                                难易程度&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach begin="2" end="${career.satisfaction}" step="1">
                                    <img src="/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                                <img src="/img/xx8.png" height="15" width="16"/></div>
                            <div class="box gird-five">
                                成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.growthCycle}</span>年
                            </div>
                            <div class="box gird-six">
                                稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.scarcity}</span><span class="time">家公司需要</span>
                            </div>
                            <div class="box gird-seven">
                            </div>
                            <div class="box gird-eight">
                                <span class="time"> 0-1年 <span class="digit">${career.payZeroOne}/月</span></span>
                            </div>
                            <div class="box gird-nine">
                                薪资待遇
                            </div>
                            <div class="box gird-ten">
                                <span class="time">1-3年 <span class="digit">${career.payOneThree}/月</span></span>
                            </div>
                            <div class="box gird-eleven">
                                <span class="time">3-5年 <span  class="digit">${career.payThreeFive}/月</span></span>
                            </div>
                            <div class="box gird-twelve">
                            </div>
                            <div class="box gird-thirteen">
                                <span class="ios-box">有<span class="number-n">${career.num}</span>人在学</span>
                            </div>
                            <div class="box gird-fifteen">
                                    ${career.need}
                            </div>
                            <div class="engineer">
                                <p>${career.careerType}</p>
                                <p>${career.careerDetails}
                                </p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="row front-end-det-dir">
            <p id="ptt3">运营方向</p>
        </div>
        <div class="row">
            <c:forEach items="${careers}" var="career"  >
                <c:if test="${career.careerType == '移动开发'}">
                    <div class=" col-xs-12 col-md-6 col-lg-4 now">
                        <div class="wrapper">
                            <div class="box gird-one">
                                <img src="${career.headImg}" height="139" width="139"/>
                            </div>
                            <div class="box gird-two">
                                <p class="ios-box">${career.name}</p>
                                <p>${career.careerBrief}
                                </p>
                            </div>
                            <div class="box gird-three">
                                门槛&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach begin="1" end="${career.threshold}" step="1">
                                    <img src="/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-four">
                                难易程度&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach begin="2" end="${career.satisfaction}" step="1">
                                    <img src="/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                                <img src="/img/xx8.png" height="15" width="16"/></div>
                            <div class="box gird-five">
                                成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.growthCycle}</span>年
                            </div>
                            <div class="box gird-six">
                                稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${career.scarcity}</span><span class="time">家公司需要</span>
                            </div>
                            <div class="box gird-seven">
                            </div>
                            <div class="box gird-eight">
                                <span class="time"> 0-1年 <span class="digit">${career.payZeroOne}/月</span></span>
                            </div>
                            <div class="box gird-nine">
                                薪资待遇
                            </div>
                            <div class="box gird-ten">
                                <span class="time">1-3年 <span class="digit">${career.payOneThree}/月</span></span>
                            </div>
                            <div class="box gird-eleven">
                                <span class="time">3-5年 <span  class="digit">${career.payThreeFive}/月</span></span>
                            </div>
                            <div class="box gird-twelve">
                            </div>
                            <div class="box gird-thirteen">
                                <span class="ios-box">有<span class="number-n">${career.num}</span>人在学</span>
                            </div>
                            <div class="box gird-fifteen">
                                    ${career.need}
                            </div>
                            <div class="engineer">
                                <p>${career.careerType}</p>
                                <p>${career.careerDetails}
                                </p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>

        </div>
    </div>
</main>
