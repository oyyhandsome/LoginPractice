<%--
  Created by IntelliJ IDEA.
  User: 热爱生活，学无止境
  Date: 2022/4/2
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>私人计分器网</title>
</head>
<body>
<h1>欢迎使用</h1>
<input type="button" value="查询所有分数"  id="research"><input type="button" value="重新归零所有分数"  id="returnToZero"><br>
<hr>


    <form action="/brand-demo/countScoreServlet" method="post">
        <table border="1" bordercolor="#0000ff" cellpadding=10 cellspacing=0 width=600>
            <th colspan="2"> <font color="red" size="8">欢迎使用哥的计分器</font><br/> </th>
            <tr>
                <td>炸弹数量</td>
                <td><input type="text" name="num" value="0"/></td>
            </tr>
            <tr>
                <td>谁是地主</td>
                <td>
                    <select name="host">
                        <option value="阳爷"checked="checked">--阳爷--</option>
                        <option value="欧阳雪">--欧阳雪--</option>
                        <option value="贺震">--贺震--</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>地主输赢</td>
                <td>
                    <input type="radio" name="win" value="0"/>输
                    <input type="radio" name="win" value="1" checked="checked"/>赢</td>
            </tr>

            <tr>
                <th colspan="2"><input type="reset" value="清除数据">

                    <input type="submit" value="提交数据"></th>

            </tr>
        </table>
    </form>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>游戏玩家</th>
        <th>分数</th>
    </tr>
    <c:forEach items="${roles}" var="role" varStatus="status">
        <tr align="center">
                <%--<td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${role.username}</td>
            <td>${role.score}</td>
        </tr>
    </c:forEach>
</table>

<script>
    document.getElementById("research").onclick = function (){
        location.href = "/brand-demo/selectAllScoreServlet";
    }
    document.getElementById("returnToZero").onclick = function (){
        location.href = "/brand-demo/returnToZeroServlet";
    }
</script>

</body>
</html>
