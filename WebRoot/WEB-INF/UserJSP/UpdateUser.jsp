<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@include file="../CommonJSP/CommonHead.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title><s:text name="updateUser"></s:text></title>
    
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
    <h1 align="center"><s:text name="updateUser"></s:text></h1>
    
    
    	
    <center>
    	<s:actionerror/>
    	<s:form action="updateUser" namespace="/" method="post">
    		<s:token></s:token>
    		<s:hidden name="user.id" value="%{user.id}"></s:hidden>
    		<s:hidden name="user.pwd" value="%{user.pwd}"></s:hidden>
    		<s:textfield name="user.username" key="username" value="%{user.username}" ></s:textfield>
    		<s:password name="newpwd" key="newpassword"></s:password>
    		<s:password name="repwd" key="repwd"></s:password>
    		<s:textfield name="user.realname" key="realname" value="%{user.realname}"></s:textfield>
    		<s:textfield name="user.grade" key="grade" value="%{user.grade}"></s:textfield>
    		<s:textfield name="user.invitaCode" key="invitaCode" value="%{user.invitaCode}"></s:textfield>
    		<s:submit key="submit"></s:submit>
    	
    	</s:form>
    </table>
    
    
    <br/><br/><br/>
    <s:a href="redirect_gotoListUser">>><s:text name="manageUser" /></s:a>
    </center>
     
  </body>
</html>
