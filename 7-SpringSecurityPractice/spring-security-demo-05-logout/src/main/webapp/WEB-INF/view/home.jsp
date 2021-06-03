<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>

<body>
    <h2>Home Page</h2>
    <hr>

    <p>Welcome to home page ..!</p>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>
</body>
</html>