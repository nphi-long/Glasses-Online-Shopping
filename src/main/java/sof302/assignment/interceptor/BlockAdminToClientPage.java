package sof302.assignment.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sof302.assignment.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BlockAdminToClientPage extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return true;
        } else {
            User user = (User) session.getAttribute("user");
            if (user.getRole().equals("A")) {
                RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath() + "/notfound");
                rd.forward(request, response);
                return false;
            } else {
                return true;
            }
        }
    }
}
