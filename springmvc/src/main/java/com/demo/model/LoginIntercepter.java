package com.demo.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.indexOf("/login") <= 0) {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user != null) {
                //登陆成功的用户  
                return true;
            } else {
                //没有登陆，转向登陆界面
                request.getRequestDispatcher("../view/Index.jsp").forward(request, response);
                return false;
            }
        } else {
            return true;
        }
    }
}
