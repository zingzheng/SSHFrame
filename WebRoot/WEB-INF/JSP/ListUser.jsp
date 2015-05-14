<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../JSP/CommonHead.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title><s:text name="manageUser"></s:text></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1 align="center"><s:text name="manageUser"></s:text></h1>
    
    
    	<s:actionerror/>
    <center>
    <table>
    	<tr>
    		<td><s:text name="id"/></td>
    		<td><s:text name="username"/></td>
    		<td><s:text name="realname"/></td>
    		<td><s:text name="grade" /></td>
    		<td><s:text name="invitaCode" /></td>
    		<td><s:text name="updateUser" /></td>
    		<td><s:text name="delUser" /></td>
    	</tr>
    	
    	<s:iterator value="#request.users" id="user">
    	<tr>
    		<td><s:property value="#user.id"/></td>
    		<td><s:property value="#user.username"/></td>
    		<td><s:property value="#user.realname"/></td>
    		<td><s:property value="#user.grade"/></td>
    		<td><s:property value="#user.invitaCode"/></td>
    		<td><s:a href="updateUserPre.action?user.id=%{#user.id}"><s:text name="updateUser"/></s:a></td>
    		<td><s:a href="delUser.action?user.id=%{#user.id}"><s:text name="delUser"/></s:a></td>
    	</tr>
    	
    	
    	</s:iterator>
    </table>
    <br/><br/>
   
  	
    <s:text name="page"></s:text>:
    <s:property value="%{page.pageCurrent}"/>/<s:property value="%{page.pageSum}"/>
   	<br/>
   	
   	<s:if test="%{page.PageCurrent!=1}">
   		<a href="listUser.action?page.pageGoto=${page.pageCurrent-1}">
			<s:text name="prepage"/>
		</a>
   	</s:if>
   	
    <c:forEach begin="1" end="${page.pageSum}" var="i">
   		<c:if test="${page.pageCurrent==i}">
			[${i}]
   		</c:if>
   		<c:if test="${page.pageCurrent!=i}">
			<a href="listUser.action?page.pageGoto=${i}">[${i}]</a>
   		</c:if>    	
    </c:forEach>
    
     <s:if test="%{page.PageCurrent!=page.pageSum}">
   		<a href="listUser.action?page.pageGoto=${page.pageCurrent+1}">
   			<s:text name="nextpage"/>
   		</a>
   	</s:if>
   	
    <br/><br/><br/>
    <s:a href="redirect_gotoMain"><s:text name="back" /></s:a>
    </center>
     
  </body>
</html>
