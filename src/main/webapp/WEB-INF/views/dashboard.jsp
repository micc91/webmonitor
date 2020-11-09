<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 05/11/2020
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:useBean id="uvmsConnection" scope="request" type="com.example.duas.UvmsConnection"/>
<jsp:useBean id="statusList" scope="request" type="java.util.List"/>
<jsp:useBean id="companyList" scope="request" type="java.util.List"/>
<jsp:useBean id="areaList" scope="request" type="java.util.List"/>
<jsp:useBean id="versionList" scope="request" type="java.util.List"/>
<jsp:useBean id="nodeList" scope="request" type="java.util.List"/>
<jsp:useBean id="duasList" scope="request" type="java.util.List"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Michael Checler, adapted from Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">

    <title>Dashboard</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="./styles/bootstrap.min.css" crossorigin="anonymous" type="text/css">

    <!-- Custom styles for this template -->
<!--    <link href="./styles/signin.css" rel="stylesheet" type="text/css">
-->
    <link href="./styles/custom.css" rel="stylesheet" type="text/css">
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
</head>
<body>
    <%@ include file="menu.jsp" %>
    <h1>to be fixed</h1>
    <div class="container-fluid">
        <div class="row">
            <!--<header>-->
            <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column">
                        <c:forEach var="node" items="${nodeList}" varStatus="status">
                            <c:choose>
                                <c:when test="${statusList[status.count-1] == 'CONNECTED'}"><c:set var="color" value="green" /></c:when>
                                <c:otherwise><c:set var="color" value="red" /></c:otherwise>
                            </c:choose>
                            <li class="nav-item" style="color:${color}">
                                    <c:out value="${companyList[status.count-1]}:${node}:${areaList[status.count-1]}" />
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </nav>

            <!--</header>-->
            <!--<h1>to be fixed...</h1>-->
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">Job runs</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                        <div class="btn-group mr-2">
                            <button type="button" class="btn btn-sm btn-outline-secondary">Refresh</button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                        </div>
                        <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                            <span data-feather="calendar"></span>
                            This week
                        </button>
                    </div>
                </div>

                <!--            <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>-->

                <h2>Section title</h2>
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Header</th>
                            <th>Header</th>
                            <th>Header</th>
                            <th>Header</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1,001</td>
                            <td>Lorem</td>
                            <td>ipsum</td>
                            <td>dolor</td>
                            <td>sit</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </main>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
<!--<script src="dashboard.js"></script></body>-->
</html>
