<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <style>
        .failed{
            color: red;
        }
    </style>
</head>
<body>
    <h2> My custom login page</h2>

    <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                method="POST">
        <!-- check for login error -->
        <c:if test="${param.error != null}">
            <i class="failed"> Sorry! you enter invalid credentials..</i>
        </c:if>
        <p>
            User name: <input type="text" name="username"/> <!-- "username" is default value spring security will look for -->
        </p>
        <p>
            Password: <input type="password" name="password"/> <!-- "password" is default value spring security will look for -->
        </p>
        <input type="submit" value = "Login" />
    </form:form>
</body>
</html>