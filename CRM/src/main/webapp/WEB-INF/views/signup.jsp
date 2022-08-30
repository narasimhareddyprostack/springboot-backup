<html>

<head>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>

<body>
    <nav class="navbar navbar-dark bg-dark navbar-expand-lg">
        <a href="#" class="navbar-brand">Spring Boot - CRM Application</a>
        <div class="ml-auto">
            <ul class="navbar-nav">
                <li class="nav-list"> <a class="nav-link" href="signup">Signup</a></li>
                <li class="nav-list"> <a class="nav-link" href="login">Exiting User</a></li>

            </ul>
        </div>
    </nav>
    <div class="container mt-4">
        <div class="row">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header bg-dark text-white">
                        <h3>Registration</h3>
                    </div>
                    <div class="card-body">
                        <form:form action="save" method="post" modelAttribute="custBean">
                            <div class="form-group">
                                <form:input placeholder="User Name" required="required" type="text" path="firstName" class="form-control" />
                            </div>
                            <div class="form-group">
                                <form:input placeholder="Email" type="text" required="required" path="email" class="form-control" />
                            </div>
                            <div class="form-group">
                                <form:input placeholder="Mobile" type="text" required="required" path="mobile" class="form-control" />
                            </div>
                            <div class="form-group">
                                <form:input placeholder="password" type="text" required="required" path="password" class="form-control" />
                            </div>
                            <input type="submit" class="btn btn-warning" value="SignUp">
                            </form:form>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>

</html>