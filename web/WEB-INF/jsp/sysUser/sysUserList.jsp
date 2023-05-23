<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Siyu
  Date: 2023/5/19
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>查询用户列表</h1>
  <form action="/user/list" method="post">
    用户名称:<input type="text" name="realName" value=""/>
    <input type="submit" name="查询">
  </form>
  <c:forEach var="sysUser" items="${queryUsers}">
    <div>
      id:${sysUser.id}
      用户编码:${sysUser.account}
      用户名称:${sysUser.realName}
      用户密码:${sysUser.password}
      用户地址:${sysUser.address}
    </div>
  </c:forEach>
</body>
</html>
