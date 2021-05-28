<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer confirmation</title>
</head>

<body>
The customer is confirmed :${customer.firstName} ${customer.lastName}
<br>
Free passes: ${customer.freePasses}
<br>
Postal code: ${customer.postalCode}
<br>
Course code: ${customer.courseCode}
</body>
</html>