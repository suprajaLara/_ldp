<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
    <h2>Home Page</h2>
    <hr>

    <p>Welcome to home page ..!</p>

    <!-- display username and role -->
    <p>
        User: <security:authentication property="principal.username"/>
        <br/><br/>
        Role(s):  <security:authentication property="principal.authorities"/>
    </p>
    <hr>
    <security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">Leadership Meet</a>
        (Only for Managers)
    </p>
    </security:authorize>
    <security:authorize access="hasRole('ADMIN')">
     <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meet</a>
        (Only for Admin)
    </p>
    </security:authorize>
    <hr>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>
</body>
</html>