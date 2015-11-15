<%--
  Created by IntelliJ IDEA.
  User: ginva_000
  Date: 11.11.2015
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="DAO.beans.Tour" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Hello</p>
<jsp:useBean id="tour" class="DAO.beans.Tour" scope="request" type="DAO.beans.Tour" />
<jsp:getProperty name="tour" property="name" />
<jsp:getProperty name="tour" property="type" />
<jsp:getProperty name="tour" property="description" />
<jsp:getProperty name="tour" property="price" />
</body>
</html>
