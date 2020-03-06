package com.example.filter.filter;


import com.example.filter.Service.impl.Showipimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},filterName = "IpFilter")
public class IpFilter implements Filter {

    @Autowired
    Showipimpl showipimpl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String val = httpServletRequest.getParameter("val");
        String s = showipimpl.selectIp(val);
        if(!StringUtils.isEmpty(val)){
            if(s.equals(val)){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                httpServletRequest.getRequestDispatcher("/notfind").forward(servletRequest,servletResponse);
            }

        }else {
            httpServletRequest.getRequestDispatcher("/notfind").forward(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
