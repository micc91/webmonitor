<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 05/11/2020
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:useBean id="uvmsConnection" scope="request" type="com.webops.duas.UvmsConnection"/>

<jsp:useBean id="statusList" scope="request" type="java.util.List"/>
<jsp:useBean id="companyList" scope="request" type="java.util.List"/>
<jsp:useBean id="areaList" scope="request" type="java.util.List"/>
<jsp:useBean id="versionList" scope="request" type="java.util.List"/>
<jsp:useBean id="nodeList" scope="request" type="java.util.List"/>

<jsp:useBean id="jobNodeList" scope="request" type="java.util.List"/>
<jsp:useBean id="jobIdList" scope="request" type="java.util.List"/>
<jsp:useBean id="jobStatusList" scope="request" type="java.util.List"/>
<jsp:useBean id="beginList" scope="request" type="java.util.List"/>
<jsp:useBean id="endList" scope="request" type="java.util.List"/>
<jsp:useBean id="infoList" scope="request" type="java.util.List"/>
<jsp:useBean id="otherList" scope="request" type="java.util.List"/>

<jsp:useBean id="nodesList" scope="request" type="java.util.List"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
    <div class="container-fluid">
        <div class="row">
            <!--<header>-->
            <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">

                    <form class="nav flex-column" action="./dashboard" method="post" >
                        <h2>Context</h2>
                        <c:forEach var="item" items="${nodesList}" varStatus="status">
                            <c:choose>
                                <c:when test="${item.get('status') == 'CONNECTED'}"><c:set var="activation" value="" /></c:when>
                                <c:otherwise><c:set var="activation" value="disabled" /></c:otherwise>
                            </c:choose>
                            <c:set var="current" value="${status.index}" />
                            <div class="checkbox ${activation}">
                                <label for="${current}" class="nav-item ${activation}">
                                    <input id="${current}" value="${current}" class="nav-item ${activation}" type="checkbox" name="selectedNodes" ${activation}>
                                        ${item.get("company")}:${item.get("node")}:${item.get("area")}
                                    </input>
                                </label>
                            </div>
                        </c:forEach>
                        <button class="btn btn-sm btn-default btn-block btn-outline-secondary" type="submit">Select</button>
                    </form>
                </div>
            </nav>

            <!--</header>-->
            <!--<h1>to be fixed...</h1>-->
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4 bg-dashboard">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
                    <h1 class="h2">Job runs</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                        <div class="btn-group mr-2">
                            <button type="button" class="btn btn-sm btn-outline-secondary"><a href="./dashboard">Refresh</a></button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">New Run</button>
                        </div>
                        <select class="btn btn-sm btn-outline-secondary dropdown-toggle">
                            <option>H - 5 min</option>
                            <option>H - 1 hour</option>
                            <option>H - 6 hours</option>
                            <option>H - 12 hours</option>
                            <option>D - 1 day</option>
                            <option>D - 2 days</option>
                            <option>Any Time</option>
                        </select>
                    </div>
                </div>

                <!--            <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>-->

                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>Company|Node|Area</th>
                            <th>Task|Session|Uproc@MU</th>
                            <th>Status</th>
                            <th>Begin Date/Time</th>
                            <th>End Date/Time</th>
                            <th>Information</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="job" items="${jobIdList}" varStatus="status">
                                <c:set var="idx" value="${status.count-1}" />

                                <c:set var="nodeid" value="${fn:split(jobNodeList[idx],'|')}" />
                                <c:set var="company" value="${nodeid[0]}" />
                                <c:set var="node" value="${nodeid[0]}" />
                                <c:set var="area" value="${nodeid[0]}" />

                                <c:set var="jobid1" value="${fn:replace(job,'|',';')}" />
                                <c:set var="jobid2" value="${fn:replace(job,'@',';')}" />
                                <c:set var="jobid" value="${fn:split(jobid2,';')}" />
                                <c:set var="task" value="${jobid[0]}" />
                                <c:set var="session" value="${jobid[1]}" />
                                <c:set var="uproc" value="${jobid[2]}" />
                                <c:set var="mu" value="${jobid[3]}" />

                                <c:choose>
                                    <c:when test="${jobStatusList[idx] == 'RUNNING'}"><c:set var="jobtype" value="ctl" /></c:when>
                                    <c:when test="${jobStatusList[idx] == 'COMPLETED'}"><c:set var="jobtype" value="ctl" /></c:when>
                                    <c:when test="${jobStatusList[idx] == 'ABORTED'}"><c:set var="jobtype" value="ctl" /></c:when>
                                    <c:when test="${jobStatusList[idx] == 'RUNNING'}"><c:set var="jobtype" value="ctl" /></c:when>
                                    <c:otherwise><c:set var="jobtype" value="fla" /></c:otherwise>
                                </c:choose>
                                <c:set var="other" value="${fn:split(otherList[idx],';')}" />
                                <c:choose>
                                    <c:when test="${jobtype == 'ctl'}">
                                        <c:set var="numsess" value="${other[0]}" />
                                        <c:set var="numproc" value="${other[1]}" />
                                        <c:set var="pdate" value="${other[2]}" />
                                        <c:set var="queue" value="${other[3]}" />
                                        <c:set var="priority" value="${other[4]}" />
                                        <c:set var="infolink" value="./info?company=${company}&node=${node}&area=${area}&task=${task}&session=${session}&uproc=${uproc}&mu=${mu}&numsess=${numsess}&numproc=${numproc}&pdate=${pdate}&queue=${queue}&priority=${priority}&status=${jobStatusList[idx]}&info=${infoList[idx]}&begin=${beginList[idx]}&end=${endList[idx]}" />
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="numlanc" value="${other[0]}" />
                                        <c:set var="pdate" value="${other[1]}" />
                                        <c:set var="queue" value="${other[2]}" />
                                        <c:set var="priority" value="${other[3]}" />
                                        <c:set var="step" value="${other[4]}" />
                                        <c:set var="infolink" value="#" />
                                    </c:otherwise>
                                </c:choose>
                                <tr>
                                    <td>${jobNodeList[idx]}</td>
                                    <td>${job}</td>
                                    <td class="status-${jobStatusList[idx]}">${jobStatusList[idx]}</td>
                                    <td>${beginList[idx]}</td>
                                    <td>${endList[idx]}</td>
                                    <td>${infoList[idx]}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <h1>End...</h1>
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
