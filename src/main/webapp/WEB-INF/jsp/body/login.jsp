<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/27 0027
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6" style="text-align: center">
                <div class="col-md-6" style="padding:100px">
                    <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">
                </div>
            </div>
            <div class="col-md-6">
                <div class="col-md-6"><h1 color="black">${msg}</h1></div>
                <div class="col-md-6" style="margin:200px auto">
                    <form action="/a/u/login" method="post" >
                        <table>
                            <tr>
                                <td width="70px"><label>用户名</label></td>
                                <td><input type="text" name="username"  required=""
                                           oninvalid="this.setCustomValidity('用户名为空,请输入用户名')" oninput="setCustomValidity('')"></td>
                            </tr>
                            <tr>
                                <td width="70px"><label>密码</label></td>
                                <td><input  type="password" name="password" required=""  oninvalid="this.setCustomValidity('密码为空,请输入密码')" oninput="setCustomValidity('')" ></td>
                            </tr>
                            <tr>
                                <td width="70px" colspan="2" align="center"><input type="submit" value="登录" >
                                    </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

