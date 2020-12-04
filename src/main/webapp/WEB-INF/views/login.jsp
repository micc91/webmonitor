<%@ page pageEncoding="UTF-8" isELIgnored ="false" %>
<%--<jsp:useBean id="uvmsConnection" scope="request" type="com.webops.duas.UvmsConnection"/>--%>
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
        <link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>" crossorigin="anonymous" type="text/css" >

        <!-- Custom styles for this template -->
        <link rel="stylesheet" href="<c:url value='/styles/custom.css'/>" crossorigin="anonymous" type="text/css" >
        <link href="<c:url value='/styles/signin.css'/>" rel="stylesheet" type="text/css">
    </head>

    <body class="bg-login">
        <header>
            <%@ include file="menu.jsp" %>
        </header>
        <main role="main" class="container text-center">
            <div class="jumbotron semi-transparent">
                <c:set var="welcome_msg" value="You are not yet connected" scope="page"></c:set>
                <c:if test="${ !empty sessionScope.uvmsConnection.login}"><c:set var="welcome_msg" value="Welcome ${sessionScope.uvmsConnection.login}" scope="page" /></c:if>
                <c:if test="${!empty returnCode && returnCode != 0}">
                    <div class="alert alert-danger" role="alert">
                        Something went wrong!
                        <p>${lastresult} (${returnCode})</p>
                    </div>
                </c:if>
                <h1 class="display-4"><c:out value="${welcome_msg}!" /></h1>
                <form class="form-signin" action="./login" method="post" >
                        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                        <label for="inputLogin" class="sr-only">Login</label>
<%--                        <input type="text" id="inputLogin" name="inputLogin" value="<c:out value="${sessionScope.uvmsConnection.login}"/>" size="20" maxlength="20" class="form-control" placeholder="User name" required autofocus>--%>
                        <input list="logins" name="inputLogin" id="inputLogin" size="20" maxlength="64" class="form-control" placeholder="User name" required autofocus>
                        <datalist id="logins">
                            <option value="<c:out value='${sessionScope.uvmsConnection.login}'/>"><c:out value="${sessionScope.uvmsConnection.login}"/></option>
                            <c:forTokens delims=":" var="item" items="${sessionScope.loginList}">
                                <option value="<c:out value='${item}'/>"><c:out value="${item}"/></option>
                            </c:forTokens>
                        </datalist>
                        <span class="error-msg">${errors['inputLogin']}</span>
                        <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" id="inputPassword" name="inputPassword" value="<c:out value="${sessionScope.uvmsConnection.password}"/>" size="20" maxlength="64" class="form-control" placeholder="Password" required>
                        <label for="inputUvms" class="sr-only">UVMS Hostname</label>
<%--                        <input type="text" id="inputUvms" name="inputUvms" value="<c:out value="${sessionScope.uvmsConnection.uvmsHost}"/>" size="20" maxlength="60" class="form-control" placeholder="UVMS Hostname" required>--%>
                        <input list="uvms" name="inputUvms" id="inputUvms" size="20" maxlength="64" class="form-control" placeholder="Univiewer Management Server Hostname" required>
                        <datalist id="uvms">
                            <option value="<c:out value='${sessionScope.uvmsConnection.uvmsHost}'/>"><c:out value="${sessionScope.uvmsConnection.uvmsHost}"/></option>
                            <c:forTokens delims=":" var="item" items="${sessionScope.uvmsList}">
                            <option value="<c:out value='${item}'/>"><c:out value="${item}"/></option>
                            </c:forTokens>
                        </datalist>
                        <span class="error-msg">${errors['inputUvms']}</span>
                        <label for="inputPort" class="sr-only">UVMS Port</label>
<%--                        <input type="text" id="inputPort" name="inputPort" value="<c:out value="${sessionScope.uvmsConnection.uvmsPort}"/>" size="20" maxlength="6" class="form-control" placeholder="UVMS Port Number" required>--%>
                            <input list="ports" name="inputPort" id="inputPort" size="10" maxlength="10" class="form-control" placeholder="TCP Port Number" required>
                            <datalist id="ports">
                                <option value="<c:out value='${sessionScope.uvmsConnection.uvmsPort}'/>"><c:out value="${sessionScope.uvmsConnection.uvmsPort}"/></option>
                                <c:forTokens delims=":" var="item" items="${sessionScope.portList}">
                                <option value="<c:out value='${item}'/>"><c:out value="${item}"/></option>
                                </c:forTokens>
                            </datalist>
                        <span class="error-msg">${errors['inputPort']}</span>
                        <div class="checkbox mb-3">
                            <label>
                                <input type="checkbox" name="remember-conn"> Remember this connection
                            </label>
                        </div>
                        <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn-signin" onclick="animateLoading('btn-signin');">Sign in</button>
                </form>
            </div>
        </main>
        <%@ include file="footer.jsp" %>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <script src="<c:url value='/scripts/custom.js'/>"></script>
</html>
