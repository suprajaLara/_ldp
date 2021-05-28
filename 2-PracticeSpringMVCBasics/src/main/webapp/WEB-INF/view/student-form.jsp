<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <form:form action="processForm" modelAttribute="student">
    First name: <form:input path="firstName"/>
    <br>
    Last name: <form:input path="lastName"/>
    <br>
    Country:
        <form:select path="country">
            <form:options items="${student.countryOptions}"/>
        </form:select>
    <br>
    Favorite language:
    Java <form:radiobutton path="favoriteLanguage" value="Java"/>
    C++ <form:radiobutton path="favoriteLanguage" value="C++"/>
    Python <form:radiobutton path="favoriteLanguage" value="Python"/>
    <br>
    Operating systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Windows <form:checkbox path="operatingSystems" value="Windows"/>
    Mac <form:checkbox path="operatingSystems" value="Mac"/>
    Android <form:checkbox path="operatingSystems" value="Android"/>
    <br>
    <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>