<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>Customer registration form</title>
    <style>
        .error{color:red}
    </style>
</head>

<body>
Fill the form. Asterisk(*) means required.
<br>
    <form:form action="processForm" modelAttribute="customer">
        First name: <form:input path="firstName"/>
        <br>
        Last name (*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
        <br>
        Free passes(*): <form:input path="freePasses"/>
        <form:errors path="freePasses" cssClass="error"/>
        <br>
        postal code: <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="error"/>
        <br>
        Course code: <form:input path="courseCode"/>
        <form:errors path="courseCode" cssClass="error"/>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>