
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
   <tiles:insertAttribute name="head" />
</head>
<body>
<tiles:insertAttribute name="header" />
<tiles:insertAttribute name="body" />
<tiles:insertAttribute name="footer" />
</body>

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="/css/jquery-3.3.1.min.js"/>
<script src="/css/bootstrap.min.js"/>
</html>
