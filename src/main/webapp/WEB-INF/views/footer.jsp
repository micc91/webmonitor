<%--
  Created by IntelliJ IDEA.
  User: mc684954
  Date: 05/11/2020
  Time: 23:53
--%>
<footer class="fixed-bottom bg-dark footer mt-auto py-3">
    <div class="container">
        <span class="text-muted">
            <c:if test="${ !empty sessionScope.uvmsConnection.login }"><p><c:out value="Connection string:${uvmsConnection.login}:####@${uvmsConnection.uvmsHost}:${uvmsConnection.uvmsPort} => ${uvmsConnection.token}" /></p></c:if>
        </span>
        <span class="text-muted">
                    <p class="mt-5 mb-3 text-muted">&copy; Michaël Checler 2020</p>
        </span>
    </div>
</footer>
