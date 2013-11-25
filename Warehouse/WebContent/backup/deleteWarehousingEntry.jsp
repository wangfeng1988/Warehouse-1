<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>deleteMaterials</title>
</head>
<body>
<h1>Update Information</h1>

<p>Use the form below to edit your information.</p>

<s:form action="delete_WarehousingEntry" method="post">
<s:textfield label="id" name="entryBean.id" /> 

<s:submit/>
</s:form>

</body>
</html>