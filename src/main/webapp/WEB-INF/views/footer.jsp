<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 05/11/2020
  Time: 23:53
--%>
<footer class="fixed-bottom bg-dark footer mt-auto py-3 footer-text">
    <div class="container">
        <div class="row mb-3">
            <div class="col-6 col-md-4 ">Dollar Universe Web Ops 1.0 - 11/2020</div>
            <div class="col-6 col-md-4 ">
                <c:choose>
                    <c:when test="${ ! empty sessionScope.uvmsConnection.uvmsHost}">
                        UVMS: ${sessionScope.uvmsConnection.uvmsHost}:${sessionScope.uvmsConnection.uvmsPort}
                    </c:when>
                    <c:otherwise>
                        UVMS: not yet defined
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col-6 col-md-4 ">
                <c:choose>
                    <c:when test="${sessionScope.uvmsConnection.token != 'disconnected'}">
                        <a class="btn btn-sm btn-outline-secondary" id="link-prefs" href="<c:url value='/preferences'/>">
                            <img src="./media/person-fill.svg" class="bi" width="32" height="32" fill="currentColor" />
                        </a>
                        ${sessionScope.uvmsConnection.login}
                    </c:when>
                    <c:otherwise>
                        <img src="./media/person.svg" class="bi" width="32" height="32" fill="currentColor" />
                        <c:if test="${ ! empty sessionScope.uvmsConnection.login}">${sessionScope.uvmsConnection.login}</c:if>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</footer>
