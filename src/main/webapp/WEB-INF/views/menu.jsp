<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="./index">Web Ops</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarCollapse">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active"><a class="nav-link" href="./index">Home <span class="sr-only">(current)</span></a></li>
<!--      <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a></li>
-->
      <c:choose>
        <c:when test="${ empty sessionScope.uvmsConnection || sessionScope.uvmsConnection.token == 'disconnected'}">
          <c:set var="loginstatus" value="" scope="request"/>
          <c:set var="logoutstatus" value="disabled" scope="request"/>
        </c:when>
        <c:otherwise>
          <c:set var="loginstatus" value="disabled" scope="request"/>
          <c:set var="logoutstatus" value="" scope="request"/>
        </c:otherwise>
      </c:choose>
      <li class="nav-item"><a class="nav-link ${loginstatus}" href="./login">Login</a></li>
      <li class="nav-item"><a class="nav-link ${logoutstatus}" href="./dashboard">Dashboard</a></li>
      <li class="nav-item"><a class="nav-link ${logoutstatus}" href="./logout">Logout</a></li>
    </ul>
<!--    <form class="form-inline mt-2 mt-md-0">-->
    <div class="form-inline mt-2 mt-md-0">
      <c:set var="disabled" value="disabled"/>
      <c:if test="${currentPage == 'dashboard' || currentPage == 'info'}"><c:set var="disabled" value=""/></c:if>
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" id="searchtext" ${disabled} >
      <button class="btn btn-outline-success my-2 my-sm-0" onclick="searchInPage()"  ${disabled} >Search</button>
<%--      <button class="btn btn-outline-success my-2 my-sm-0" onclick="clearSearchInPage()"  ${disabled} >Clear</button>--%>
    </div>
<!--    </form>-->
  </div>
</nav>