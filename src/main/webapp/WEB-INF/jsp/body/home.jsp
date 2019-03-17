<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main>
    <div class="father">
        <input type="radio" checked name="slider" id="l01">
        <input type="radio" name="slider" id="l02">
        <input type="radio" name="slider" id="l03">
        <div id="wrap">
            <ul id="slider">
                <img src="/img/html8.jpg"><img src="/img/html8.1.png"><img src="/img/html8.3.png">
            </ul>
        </div>
        <div id="opts">
            <label id="dot1" for="l01"></label>
            <label id="dot2" for="l02"></label>
            <label id="dot3" for="l03"></label>
        </div>
        <label class="dot4" for="l01"></label>
        <label class="dot5" for="l02"></label>
        <label class="dot6" for="l03"></label>
    </div>
    <div class="container content">
        <div class="row row-box">
            <div class="col-md-6  col-lg-3 col-xs-12   content-box">
                <div class="img-box">
                    <img src="/img/css8.png" height="50" width="33"/>
                </div>
                <span class="rough-font">高效</span>
                <p>将五到七年的成长时间，缩短到一年到三年。</p>
            </div>
            <div class="col-md-6 col-lg-3 col-xs-12   content-box">
                <div class="img-box">
                    <img src="/img/css8.1.png" height="50" width="50"/>
                </div>
                <span class="rough-font">规范</span>
                <p>标准的实战教程，不会走弯路</p>
            </div>
            <div class="col-md-6  col-lg-3 col-xs-12 content-box">
                <div class="img-box">
                    <img src="/img/css8.2.png" height="50" width="50"/>
                </div>
                <span class="rough-font">人脉</span>
                <p>同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</p>
            </div>
            <div class="col-md-6  col-lg-3 col-xs-12  content-box">
                <div class="content-box-profile">
                    <img src="/img/css8.3.png" height="13" width="13"/>
                    <span>${total}</span>
                    <p>累计在线学习人数</p>
                    <img src="/img/css8.3.png" height="13" width="13"/>
                    <span>${goodNum}</span>
                    <p>学员已经找到满意工作</p>
                </div>
            </div>
        </div>

        <div class="row learn">
            <p>如何学习</p>
        </div>
        <div class="row  ">
            <div class=" col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">1 </div>
                <span class="detailed">
            匹配你现在的个人情况 寻找适合自己的岗位</span>
                <span>
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">2 </div>
                <span class="detailed">
            了解职业前景薪金待遇、 竞争压力等
        </span>
                <span>
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">3 </div>
                <span class="detailed">
               掌握行业内顶级技能
        </span>
                <span>
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">4 </div>
                <span class="detailed">
            查看职业目标任务
        </span>
                <span class="clear">
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">5 </div>
                <span class="detailed">
           参考学习资源，掌握 技能点，逐个完成任务
        </span>
                <span>
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3   col-sm-6 col-xs-12 how-to-learn">
                <div class="number">6 </div>
                <span class="detailed">
         加入班级，和小伙伴们 互帮互助，一块学习
        </span>
                <span>
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">7 </div>
                <span class="detailed">
            选择导师，一路引导， 加速自己成长
        </span>
                <span>
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3   col-sm-6 col-xs-12  how-to-learn">
                <div class="number">8 </div>

                <span class="detailed">
            完成职业技能，升级业界大牛
        </span>
                <span class="clear">
        <img src="/img/task8.4.png" height="30" width="32"/></span>
            </div>
        </div>

        <div class="row learn">
            <p>优秀学员展示</p>
        </div>

        <div class="row">
            <c:forEach items="${students}" var="student">
            <div class="col-md-3  col-sm-6  content-box">
                <div class="introduce">
                    <img src="${student.headImg}" height="108" width="108"/>
                    <p class="rough-font">${student.career}：${student.name}</p>
                    <p>职位简介：${student.careerBrief}</p>
                    <p>薪水:${student.salary}</p>
                </div>
            </div>
            </c:forEach>

        <div class="row green-point">
            <div class="moving-point"></div>
            <div class="moving-point"></div>
            <div class="moving-point"></div>
            <div class="moving-point"></div>
        </div>
        <div class="row learn">
            <p>战略合作企业</p>
        </div>
        <div class="row">
            <div class="  col-md-6 col-xs-12 img-photograph">
                <div class="photograph">
                    <img src="/img/corporation8.1.png"  height="130" width="170"/>
                </div>
            </div>
            <div class="   col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/img/corporation8.2.png" height="69" width="124"/></div></div>
            <div class=" col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/img/corporation8.3.png" height="181" width="171"/>
                </div></div>
            <div class="col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/img/corporation8.4.png" height="124" width="124"/>
                </div></div>
            <div class=" col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/img/corporation8.png" height="154" width="154"/>
                </div></div>
        </div>
        <div class="learn-box">
            <div class="row learn">
                <p>友情链接</p>
            </div>

            <div class="row">
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">教师招聘</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">教师招聘</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">介绍私活</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">出售光碟</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">招聘学员</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">日常学习</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
                <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                    <div class="friendship-link">
                        <div class="box-circle">
                        </div>
                        <span class="frame">手机软件</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</main>
