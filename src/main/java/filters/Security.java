package filters;

import DAO.beans.User;
import DAO.criterias.UserCriteria;
import tools.Init;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by ginva_000 on 21.11.2015.
 */
@WebFilter(filterName = "Security", urlPatterns = "/*")
public class Security implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        Principal userPrincipal = request.getUserPrincipal();
        HttpSession session = request.getSession(false);

        //

        if (userPrincipal != null){
            User sessionUser = (User) session.getAttribute("user");
            if(sessionUser == null || sessionUser.getLogin() == null || !sessionUser.getLogin().equals(userPrincipal.getName())){
                UserCriteria criteria = Init.getDaoFactory().getUserCriteria();
                criteria.setLogin(userPrincipal.getName());
                User user = Init.getDaoFactory().getUserDao().read(criteria).get(0);
                request.getSession().setAttribute("user", user);
            }
        }
        else {
            request.getSession().setAttribute("user", new User());
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
