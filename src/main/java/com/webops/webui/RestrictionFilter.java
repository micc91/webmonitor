package com.webops.webui;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "RestrictionFilter")
public class RestrictionFilter implements Filter {
    private static final String ATTR_UVMSCONN = "uvmsConnection";
    //private static final String PAGE_WELCOME = "/index.jsp";
    private static final String PAGE_LOGIN = "/WEB-INF/views/login.jsp";

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        /* Cast des objets request et response */
        HttpServletRequest hsRequest = (HttpServletRequest) request;
        HttpServletResponse hsResponse = (HttpServletResponse) response;

        /* Non-filtrage des ressources statiques */
        String currentPath = hsRequest.getRequestURI().substring( hsRequest.getContextPath().length() );
        if ( currentPath.startsWith( "/media" ) || currentPath.startsWith( "/scripts" ) || currentPath.startsWith( "/styles" ) ||
                currentPath.startsWith( "/login" ) || currentPath.startsWith( "/index" ) || currentPath.startsWith( "/" ) || currentPath.isEmpty()) {
            chain.doFilter( hsRequest, hsResponse );
            return;
        }

        /* Récupération de la session depuis la requête */
        HttpSession session = hsRequest.getSession();

        /**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( ATTR_UVMSCONN ) == null ) {
            /* Redirection vers la page publique */
            //hsResponse.sendRedirect( hsRequest.getContextPath() + PAGE_WELCOME );
            hsRequest.getRequestDispatcher(PAGE_LOGIN).forward(hsRequest, hsResponse);
        } else {
            /* Affichage de la page restreinte */
            chain.doFilter( hsRequest, hsResponse );
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
