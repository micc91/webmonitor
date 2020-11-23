<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 05/11/2020
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:useBean id="uvmsConnection" scope="request" type="com.webops.duas.UvmsConnection"/>
<jsp:useBean id="nodesList" scope="request" type="java.util.List"/>
<jsp:useBean id="jobsList" scope="request" type="java.util.List"/>
<%-- TODO: add useBean audit --%>
<jsp:useBean id="settings" scope="session" type="java.util.Map"/>
<jsp:useBean id="selectedContext" scope="session" type="java.util.List"/>

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
                        <c:set var="idx" value="0" />
                        <c:forEach var="item" items="${nodesList}" varStatus="status">
                            <c:choose>
                                <c:when test="${item.get('status') == 'CONNECTED'}"><c:set var="activation" value="" /></c:when>
                                <c:otherwise><c:set var="activation" value="disabled" /></c:otherwise>
                            </c:choose>
                            <%-- handle selectedContext if not empty to check box for already selected nodes --%>
                            <c:set var="current" value="${status.index}" />
                            <c:set var="checkedattr" value="" />
                            <c:if test="${selectedContext[idx] == current && activation != 'disabled'}">
                                <c:set var="checkedattr" value="checked" />
                                <c:set var="idx" value="${idx + 1}" />
                            </c:if>
                            <div class="checkbox ${activation}">
                                <label for="${current}" class="nav-item ${activation}">
                                    <input id="${current}" value="${current}" class="nav-item ${activation}" type="checkbox" name="selectedNodes" ${activation} ${checkedattr} >
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
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
                    <h1 class="h2">Job runs</h1>
                    <div class="btn-toolbar mb-2 mb-md-0" > <%--role="toolbar" aria-label="toolbar with buttons">--%>
                        <div class="btn-group mr-2" > <%--role="group" aria-label="action group" > --%>
                            <%-- delete, cancel, hold, release, bypass, force, skip --%>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-action-delete" onclick="actionOnJob('delete')"><img src="./media/trash.svg"  class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-action-stop" onclick="actionOnJob('stop')"><img src="./media/exclamation-octagon-fill.svg"  class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-action-hold" onclick="actionOnJob('hold')"><img src="./media/cone-striped.svg"  class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-action-release" onclick="actionOnJob('release')"><img src="./media/caret-right-square.svg"  class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-action-bypass" onclick="actionOnJob('bypass')"><img src="./media/arrow-return-right.svg"  class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-action-force" onclick="actionOnJob('force')"><img src="./media/check2-square.svg"  class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-action-skip" onclick="actionOnJob('skip')"><img src="./media/chevron-double-right.svg"  class="bi" width="16" height="16" fill="currentColor" /></button>
                        </div>
                        <div class="btn-group mr-2" > <%--role="group" aria-label="display group" >--%>
                            <button class="btn btn-sm btn-outline-secondary" id="btn-chart" onclick="showHideChart(${xdata},${ydata})"><img src="./media/bar-chart-line.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">
                                <a href="./dashboard?refresh=true">
                                    <img src="./media/arrow-repeat.svg" class="bi" width="32" height="32" fill="currentColor" />
                                </a>
                            </button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">
                                <a href="./new">
                                New Run
                                </a>
                            </button>
                        </div>
                        <c:set var="selected5" value=""/>
                        <c:set var="selected60" value=""/>
                        <c:set var="selected360" value=""/>
                        <c:set var="selected720" value=""/>
                        <c:set var="selected1440" value=""/>
                        <c:set var="selected2880" value=""/>
                        <c:set var="selectedNone" value="selected"/>
                        <c:choose>
                            <c:when test="${settings.offset == '5'}"   ><c:set var="selected5"    value="selected"/></c:when>
                            <c:when test="${settings.offset == '60'}"  ><c:set var="selected60"   value="selected"/></c:when>
                            <c:when test="${settings.offset == '360'}" ><c:set var="selected360"  value="selected"/></c:when>
                            <c:when test="${settings.offset == '720'}" ><c:set var="selected720"  value="selected"/></c:when>
                            <c:when test="${settings.offset == '1440'}"><c:set var="selected1440" value="selected"/></c:when>
                            <c:when test="${settings.offset == '2880'}"><c:set var="selected2880" value="selected"/></c:when>
                            <c:when test="${settings.offset == 'none'}"><c:set var="selectedNone" value="selected"/></c:when>
                            <c:otherwise><c:set var="selectedNone" value="selected"/></c:otherwise>
                        </c:choose>
                        <select class="btn btn-sm btn-outline-secondary dropdown-toggle" id="select-offset" onchange="refreshJobRuns()">
                            <option value="none" ${selectedNone} >Any Time</option>
                            <option value="5"    ${selected5}    >H - 5 min</option>
                            <option value="60"   ${selected60}   >H - 1 hour</option>
                            <option value="360"  ${selected360}  >H - 6 hours</option>
                            <option value="720"  ${selected720}  >H - 12 hours</option>
                            <option value="1440" ${selected1440} >D - 1 day</option>
                            <option value="2880" ${selected2880} >D - 2 days</option>
                        </select>
                    </div>
                </div>

                <canvas class="my-4 w-100" id="jobChart" width="500" height="80" style="display: none;"></canvas>

                <div class="table-responsive">
                    <table class="table table-striped table-sm" id="jobrunsTable" >
                        <thead>
                        <tr>
                            <th data-toggle="tooltip" data-placement="top" title="Company|Node|Area" >Location
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-0-asc"  onclick="sortTable('jobrunsTable',0,'asc')"><img src="./media/chevron-up.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-0-desc" onclick="sortTable('jobrunsTable',0,'desc')"><img src="./media/chevron-down.svg" class="bi" width="16" height="16" fill="currentColor" onclick="sortTable('jobrunsTable',0,'desc')"/></button>
                            </th>
                            <th data-toggle="tooltip" data-placement="top" title="Task|Session|Uproc@MU"  >Job ID
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-1-asc" onclick="sortTable('jobrunsTable',1,'asc')"><img src="./media/chevron-up.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-1-desc" onclick="sortTable('jobrunsTable',1,'desc')"><img src="./media/chevron-down.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                            </th>
                            <th>Status
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-2-asc" onclick="sortTable('jobrunsTable',2,'asc')"><img src="./media/chevron-up.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-2-desc" onclick="sortTable('jobrunsTable',2,'desc')"><img src="./media/chevron-down.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                            </th>
                            <th>Begin Date/Time
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-3-asc" onclick="sortTable('jobrunsTable',3,'asc')"><img src="./media/chevron-up.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-3-desc" onclick="sortTable('jobrunsTable',3,'desc')"> <img src="./media/chevron-down.svg" class="bi" width="16" height="16" fill="currentColor"/></button>
                            </th>
                            <th>End Date/Time
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-4-asc" onclick="sortTable('jobrunsTable',4,'asc')"><img src="./media/chevron-up.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-4-desc" onclick="sortTable('jobrunsTable',4,'desc')"><img src="./media/chevron-down.svg" class="bi" width="16" height="16" fill="currentColor"/></button>
                            </th>
                            <th>Information
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-5-asc" onclick="sortTable('jobrunsTable',5,'asc')"><img src="./media/chevron-up.svg" class="bi" width="16" height="16" fill="currentColor" /></button>
                                <button class="btn btn-sm btn-outline-secondary" id="btn-sort-5-desc" onclick="sortTable('jobrunsTable',5,'desc')"><img src="./media/chevron-down.svg" class="bi" width="16" height="16" fill="currentColor"/></button>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:if test="${ !empty jobsList[0].get('company') }">
                                <c:forEach var="item" items="${jobsList}" varStatus="status">
                                    <c:set var="idx" value="${status.index}" />
                                    <c:choose>
                                        <c:when test="${item.get('status') == 'COMPLETED'}"><c:set var="jobtype" value="ctl" /></c:when>
                                        <c:when test="${item.get('status') == 'ABORTED'}"><c:set var="jobtype" value="ctl" /></c:when>
                                        <c:when test="${item.get('status') == 'RUNNING'}"><c:set var="jobtype" value="ctl" /></c:when>
                                        <c:otherwise><c:set var="jobtype" value="fla" /></c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${jobtype == 'ctl'}">
                                            <c:url var="infolink" value="/info">
                                                <c:param name="company" value="${item.get('company')}" />
                                                <c:param name="node" value="${item.get('node')}" />
                                                <c:param name="area" value="${item.get('area')}" />
                                                <c:param name="task" value="${item.get('task')}" />
                                                <c:param name="session" value="${item.get('session')}" />
                                                <c:param name="uproc" value="${item.get('uproc')}" />
                                                <c:param name="mu" value="${item.get('mu')}" />
                                                <c:param name="numlanc" value="${item.get('numlanc')}" />
                                                <c:param name="numsess" value="${item.get('numsess')}" />
                                                <c:param name="numproc" value="${item.get('numproc')}" />
                                                <c:param name="pdate" value="${item.get('pdate')}" />
                                                <c:param name="queue" value="${item.get('queue')}" />
                                                <c:param name="priority" value="${item.get('priority')}" />
                                                <c:param name="status" value="${item.get('status')}" />
                                                <c:param name="step" value="${item.get('step')}" />
                                                <c:param name="information" value="${item.get('information')}" />
                                                <c:param name="begin" value="${item.get('begin_date')} ${item.get('begin_time')}" />
                                                <c:param name="end" value="${item.get('end_date')} ${item.get('begin_time')}" />
                                            </c:url>
                                        </c:when>
                                        <c:otherwise>
                                            <c:url var="infolink" value="/info">
                                                <c:param name="company" value="${item.get('company')}" />
                                                <c:param name="node" value="${item.get('node')}" />
                                                <c:param name="area" value="${item.get('area')}" />
                                                <c:param name="task" value="${item.get('task')}" />
                                                <c:param name="session" value="${item.get('session')}" />
                                                <c:param name="uproc" value="${item.get('uproc')}" />
                                                <c:param name="mu" value="${item.get('mu')}" />
                                                <c:param name="numlanc" value="${item.get('numlanc')}" />
                                                <c:param name="numsess" value="${item.get('numsess')}" />
                                                <c:param name="numproc" value="${item.get('numproc')}" />
                                                <c:param name="pdate" value="${item.get('pdate')}" />
                                                <c:param name="queue" value="${item.get('queue')}" />
                                                <c:param name="priority" value="${item.get('priority')}" />
                                                <c:param name="status" value="${item.get('status')}" />
                                                <c:param name="step" value="${item.get('step')}" />
                                                <c:param name="information" value="${item.get('information')}" />
                                                <c:param name="begin" value="${item.get('begin_date')} ${item.get('begin_time')}" />
                                                <c:param name="end" value="${item.get('end_date')} ${item.get('begin_time')}" />
                                            </c:url>
                                        </c:otherwise>
                                    </c:choose>
                                    <tr>
                                        <td>${item.get("company")}|${item.get("node")}|${item.get("area")}</td>
                                        <td><a href="${infolink}">${item.get("task")}|${item.get("session")}|${item.get("uproc")}@${item.get("mu")}</a></td>
                                        <td class="status-${item.get("status")}">${item.get("status")}</td>
                                        <td>${item.get("begin_date")} ${item.get("begin_time")}</td>
                                        <td>${item.get("end_date")} ${item.get("end_time")}</td>
                                        <td>${item.get("information")}</td>
                                    </tr>

                                </c:forEach>
                            </c:if>
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
<script src="./scripts/custom.js"></script>
<script src="./scripts/dashboard.js"></script></body>

<script>
    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })
</script>
</html>
