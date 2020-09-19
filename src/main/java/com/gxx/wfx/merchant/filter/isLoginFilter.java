package com.gxx.wfx.merchant.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class isLoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        if (requestURI.endsWith("/login") || "OPTIONS".equals(method)
            || requestURI.endsWith("/memeber/register")|| requestURI.endsWith("/pay/callback")
                || requestURI.indexOf("/webSocket/")>=0){
            // 放行
            System.out.println("放行");
            filterChain.doFilter(request,response);
        } else {
            try {
                if (request.getHeader("token") != null){
                    String token = request.getHeader("token");
                    JwtParser parser = Jwts.parser();
                    parser.setSigningKey("QFedu123");
                    Jws<Claims> jws = parser.parseClaimsJws(token);
                    String subject = jws.getBody().getSubject();
                    filterChain.doFilter(request,response);
                }
            }catch (Exception e){
                e.printStackTrace();
                response.getWriter().write("认证失败");
                return;
            }
        }

    }

    public void destroy() {

    }
}
