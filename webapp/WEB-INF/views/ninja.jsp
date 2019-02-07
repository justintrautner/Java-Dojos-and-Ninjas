<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Create Ninja</title>
</head>
<body class="mt-3 ml-3">

<h1>New Ninja</h1>

 <form:form action="/ninjas" method="post" modelAttribute="newninja">
 
    <p>
        <form:label path="dojo">Dojo: </form:label>
        <form:select path="dojo">
        	<c:forEach items="${ dojos }" var="dojo">
        		<option value="${dojo.id}"><c:out value="${dojo.name}"/> </option>
        	</c:forEach>
        </form:select>
    </p>
    <p><form:errors class="text-danger" path="dojo"/></p>   
    
    <p>
        <form:label path="firstName">First Name: </form:label>
        <form:input path="firstName"/>
    </p>  
    <p><form:errors class="text-danger" path="firstName"/></p>
    
     <p>
        <form:label path="lastName">Last Name: </form:label>
        <form:input path="lastName"/>
    </p>
    <p><form:errors class="text-danger" path="lastName"/></p>
    
     <p>
        <form:label path="age">Age: </form:label>
        <form:input path="age"/>
    </p>
    <p><form:errors class="text-danger" path="age"/></p>
    
	<input type="submit" value="Create Ninja"/>
</form:form> 

</body>
</html>