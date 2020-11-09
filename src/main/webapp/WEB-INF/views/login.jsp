<%@ page pageEncoding="UTF-8" isELIgnored ="false" %>
<jsp:useBean id="uvmsConnection" scope="request" type="com.example.duas.UvmsConnection"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Michael Checler, adapted from Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v4.1.1">

        <title>Sign-in</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="./styles/bootstrap.min.css" crossorigin="anonymous" type="text/css" >

        <!-- Custom styles for this template -->
        <link href="./styles/signin.css" rel="stylesheet" type="text/css">
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-uvmsConnection-select: none;
                -moz-uvmsConnection-select: none;
                -ms-uvmsConnection-select: none;
                uvmsConnection-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
            .bg {
                background-image: url("./media/nuages.jpg");
                height: 90%;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
            .bg2 {
                background-image: url("./media/Vue_du_mont_ventoux.jpg");
                height: 90%;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }
            .error-msg {
                color: red;
            }

        </style>
<!--        <link href="./styles/sticky-footer-navbar.css" rel="stylesheet">
-->
    </head>

    <body>
        <header>
            <%@ include file="menu.jsp" %>
        </header>
        <main role="main" class="container-fluid text-center bg">
            <c:set var="welcome_msg" value="You are not yet connected" scope="page"></c:set>
            <c:if test="${ !empty uvmsConnection.login}"><c:set var="welcome_msg" value="Welcome ${uvmsConnection.login}" scope="page" /></c:if>
                <h1><c:out value="${welcome_msg}!" /></h1>

                <form class="form-signin" action="./login" method="post" >
                    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                    <label for="inputLogin" class="sr-only">Login</label>
                    <input type="text" id="inputLogin" name="inputLogin" value="<c:out value="${uvmsConnection.login}"/>" size="20" maxlength="20" class="form-control" placeholder="User name" required autofocus>
                    <span class="error-msg">${errors['inputLogin']}</span>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" name="inputPassword" value="<c:out value="${uvmsConnection.password}"/>" size="20" maxlength="20" class="form-control" placeholder="Password" required>
                    <label for="inputUvms" class="sr-only">UVMS Hostname</label>
                    <input type="text" id="inputUvms" name="inputUvms" value="<c:out value="${uvmsConnection.uvmsHost}"/>" size="20" maxlength="60" class="form-control" placeholder="UVMS Hostname" required>
                    <span class="error-msg">${errors['inputUvms']}</span>
                    <label for="inputPort" class="sr-only">UVMS Port</label>
                    <input type="text" id="inputPort" name="inputPort" value="<c:out value="${uvmsConnection.uvmsPort}"/>" size="20" maxlength="6" class="form-control" placeholder="UVMS Port Number" required>
                    <span class="error-msg">${errors['inputPort']}</span>
                    <div class="checkbox mb-3">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>

        </main>
        <%@ include file="footer.jsp" %>
    </body>
    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="./scripts/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

</html>
