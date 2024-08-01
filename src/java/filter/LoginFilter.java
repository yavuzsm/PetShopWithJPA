/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import entity.User;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Yavuz Selim
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURI();

        User u = (User) req.getSession().getAttribute("user");

        if (u == null) {
            if (url.contains("panel") || url.contains("logout")) {

                System.out.println("buraya geldi 1. if");
                res.sendRedirect(req.getContextPath() + "/login.xhtml");

            } else {
                fc.doFilter(request, response);
            }
        } else {
            if (url.contains("login")) {
                System.out.println("errror");

            } else {
                fc.doFilter(request, response);
                System.out.println("denemeee");

            }
        }
    }
}
