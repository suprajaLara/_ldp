<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    student is confirmed: ${student.firstName} ${student.lastName}
    <br>
    country : ${student.country}
    <br>
    favorite language : ${student.favoriteLanguage}
    <br>
    operating systems :
    <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
        </c:forEach>
    </ul>
</body>
</html>