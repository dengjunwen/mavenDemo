package com.cgq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cgq.util.CheckUtil;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(); 
		Object uid = req.getSession().getAttribute("uid");
		req.setCharacterEncoding("utf-8");
		res.setHeader("Pragma","No-cache");
		res.setHeader("Cache-Control","no-cache");
		res.setDateHeader("Expires", 0);
		if (CheckUtil.isEmpty(uid)) {     
			session.removeAttribute("uid");
			session.invalidate();
			String path=req.getContextPath()+"/indexlogin";
			res.getWriter().write("<script type=\"text/javascript\">window.parent.location.href=\""+path+"\"</script>");
			return;    
		} else {    
			chain.doFilter(request, response); 
		}    
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
