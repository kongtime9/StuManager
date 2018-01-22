package com.stu.filter;

import com.stu.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LARK on 2017/12/12.
 * 登录过滤器
 */

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();

		// 获取用户请求的URI
		String path = servletRequest.getRequestURI();

		// 获取session中用户名信息
		User user = (User) session.getAttribute("login_user");
		if(user!=null) {
			chain.doFilter(request, response);
			return;
		}
		// 判断是否为登陆界面，如果是登陆界面则放行，否则进行用户信息检查
		if(path.contains("/login.jsp") || path.contains("userLogin") || path.contains("/error.jsp")) {
			chain.doFilter(request, response);
			return;
		}else if(path.endsWith(".css")||path.endsWith(".js")||path.endsWith(".ttf")||path.endsWith(".ico")||path.endsWith(".png")||path.endsWith(".jpg")) {
			chain.doFilter(request, response);
			return;
		}else {
			if(user == null) {
				servletResponse.sendRedirect(servletRequest.getContextPath() + "/pages/login.jsp");
				chain.doFilter(request, response);
				return;
			}
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
