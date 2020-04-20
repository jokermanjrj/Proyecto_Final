<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello World!</title>
  </head>
  <body>
 <s:iterator value="messageStore.message">
        <s:property value="%{id}"/>
        <s:property value="%{title}"/>
        <s:property value="%{message}"/>
        <button>hola</button>
        <br> 
</s:iterator>   
  </body>	
</html>
