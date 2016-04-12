/**
 * 
 */
package com.xq.wechat.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author rwq
 *
 */
@WebFilter(filterName="loginFilter", urlPatterns="/*")
public class LoginFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获得在下面代码中要用的request,response,session对象
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        //System.out.println(path);
        
        // 从session里取用户登录信息
        Boolean loginState = (Boolean) session.getAttribute("LOGIN");

        /*创建类Constants.java，里面写的是无需过滤的页面
        for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {

            if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        }*/
        
        // 登陆页面无需过滤
        if(path.indexOf("/user/login") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 判断如果没有取到员工信息,就跳转到登陆页面
        if (loginState == null || !loginState) {
        	String json = "{\"modul\": \"login\", \"ErrorId\": \"403\", \"expDescription\": \"please login\"}";
        	response.setContentType("application/json");
            response.getWriter().write(json);
            return;
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(request, response);
        }

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
