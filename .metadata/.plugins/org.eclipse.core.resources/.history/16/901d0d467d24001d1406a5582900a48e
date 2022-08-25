<html>

<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<nav class="navbar navbar-dark bg-dark">
	<a href="#" class="navbar-brand"> Customer Registration Page</a>
	</nav>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <form:form action="save" method="post" modelAttribute="custBean">
                    <div class="form-group">
                        <form:input placeholder="First Name" type="text" path="firstName" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:input placeholder="Email" type="text" path="email" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <form:input  placeholder="Mobile" type="text" path="mobile" class="form-control"/>
                    </div>
                     <div class="form-group">
                        <form:input placeholder="Password" type="text" path="password" class="form-control"/>
                    </div>
                    <input type="submit" class="btn btn-primary" value="Registration"/>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>