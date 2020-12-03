<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 02/12/2020
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" isELIgnored ="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Michael Checler, adapted from Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">

    <title>Preferences</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sign-in/">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/styles/bootstrap.min.css'/>" crossorigin="anonymous" type="text/css" >

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="<c:url value='/styles/custom.css'/>" crossorigin="anonymous" type="text/css" >
</head>

<body class="bg-other">
<header>
    <%@ include file="menu.jsp" %>
</header>
<main role="main" class="container text-center">
    <div class="jumbotron semi-transparent">
        <h1 class="h3 mb-3 font-weight-normal">Update your settings</h1>
        <c:if test="${!empty returnCode && returnCode != 0}">
            <div class="alert alert-danger" role="alert">
                Something went wrong!
                <p>${lastresult} (${returnCode})</p>
            </div>
        </c:if>
        <c:if test="${!empty returnCode && returnCode == 0 && !empty lastResult}">
            <div class="alert alert-success" role="alert">
                Settings successfully saved
            </div>
        </c:if>
        <form class="form-signin" action="<c:url value='/preferences'/>" method="post" >
            <div class="form-group">
            <label for="inputTimer" >Refresh timer interval for Job Runs Dashboard</label>
            <select class="form-control" id="inputTimer" name="inputTimer">
                <c:forEach var="item" items="${sessionScope.preferences.selectValues.get('timer')}" varStatus="status" >
                    <c:set var="value" value="${fn:split(item, '#')[0]}"/>
                    <c:set var="brutlabel" value="${fn:split(item, '#')[1]}"/>
                    <c:set var="label" value="${fn:replace(brutlabel, '_', ' ')}"/>
                    <c:set var="selected" value=""/>
                    <c:if test="${item == sessionScope.preferences.timer}"><c:set var="selected" value="selected"/></c:if>
                    <option value="${item}" ${selected}>${label}</option>
                </c:forEach>
            </select>
                <span class="error-msg">${errors['inputTimer']}</span>
            </div>
            <div class="form-group">
            <label for="inputOffset" >Offset time for Job Runs Dashboard (filter on start date)</label>
            <select class="form-control" id="inputOffset" name="inputOffset">
                <c:forEach var="item" items="${sessionScope.preferences.selectValues.get('offset')}" varStatus="status" >
                    <c:set var="value" value="${fn:split(item, '#')[0]}"/>
                    <c:set var="brutlabel" value="${fn:split(item, '#')[1]}"/>
                    <c:set var="label" value="${fn:replace(brutlabel, '_', ' ')}"/>
                    <c:set var="selected" value=""/>
                    <c:if test="${item == sessionScope.preferences.offset}"><c:set var="selected" value="selected"/></c:if>
                    <option value="${item}" ${selected}>${label}</option>
                </c:forEach>
            </select>
                <span class="error-msg">${errors['inputOffset']}</span>
            </div>
            <div class="form-group">
            <label for="inputChart" >Chart Display Mode</label>
            <select class="form-control" id="inputChart" name="inputChart">
                <c:forEach var="item" items="${sessionScope.preferences.selectValues.get('chart')}" varStatus="status" >
                    <c:set var="value" value="${item}"/>
                    <c:set var="label" value="${item}"/>
                    <c:set var="selected" value=""/>
                    <c:if test="${item == sessionScope.preferences.chart}"><c:set var="selected" value="selected"/></c:if>
                    <option value="${value}" ${selected}>${label}</option>
                </c:forEach>
            </select>
                <span class="error-msg">${errors['inputChart']}</span>
            </div>
            <div class="form-group">
            <label for="inputLwSize" >Launch Window Size for new run (in minutes)</label>
            <input type="text" id="inputLwSize" name="inputLwSize" value="<c:out value="${sessionScope.preferences.launchWindowSize}"/>" size="20" maxlength="20" class="form-control" placeholder="" autofocus>
            <span class="error-msg">${errors['inputLwSize']}</span>
            </div>
            <div class="form-group">
            <label for="inputAccount" >Submission Account for new run</label>
            <input type="text" id="inputAccount" name="inputAccount" value="<c:out value="${sessionScope.preferences.submissionAccount}"/>" size="20" maxlength="20" class="form-control" placeholder="" autofocus>
            <span class="error-msg">${errors['inputAccount']}</span>
            </div>
            <div class="form-group">
            <label for="inputQueue" >Batch Queue for new run</label>
            <input type="text" id="inputQueue" name="inputQueue" value="<c:out value="${sessionScope.preferences.batchQueue}"/>" size="20" maxlength="20" class="form-control" placeholder="" autofocus>
            <span class="error-msg">${errors['inputQueue']}</span>
            </div>
            <div class="form-group">

            <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn-update-prefs" onclick="animateLoading('btn-update-prefs');">Save</button>
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
