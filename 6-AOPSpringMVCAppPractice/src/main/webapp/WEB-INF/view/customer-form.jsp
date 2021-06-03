<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<%@ page isELIgnored="false" %>
    <title>Save customer</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css"
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2> Save customer </h2>
            <form:form action="saveCustomer" modelAttribute="customer" method="POST">
               <!-- associate this data with customer id (tracks the id of which customer to update, when submitted it calls setId() -->
               <form:hidden path="id"/>
                <table>
                    <tbody>
                    <tr>
                        <td><label>First name:</label></td>
                        <td><form:input path="firstName"/></td>
                    </tr>
                     <tr>
                        <td><label>Last name:</label></td>
                        <td><form:input path="lastName"/></td>
                    </tr>
                     <tr>
                        <td><label>Email:</label></td>
                        <td><form:input path="email"/></td>
                    </tr>
                     <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" class="save"/></td>
                    </tr>
                    </tbody>
                </table>
            </form:form>

            <div style="clear;both;"></div>
            <p>
               <a href="${pageContext.request.contextPath}/customer/list">back to list</a>
            </p>
        </div>
    </div>
</body>
</html>