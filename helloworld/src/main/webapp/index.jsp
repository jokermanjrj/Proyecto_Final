<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
  </head>
  <body>
   <h1>Welcome To Struts 2!</h1>
        <p><a href="<s:url action='hello'/>">Hello World</a></p>
    <s:form action="register">
    	<s:textfield label="username" key="username"/>
    	<s:textfield label="password" key="password"/>
    	<s:submit/>
    </s:form>    
    <p><a href="<s:url action='calendar'/>">Log</a></p>
  </body>
</html>
