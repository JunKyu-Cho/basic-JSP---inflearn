package com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TempFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("-- filter init() --");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("-- filter doFilter() --");

		// request Filter
		request.setCharacterEncoding("UTF-8");
		
		chain.doFilter(request, response);
		
		// response Filter
	}
	
	@Override
	public void destroy() {
		System.out.println("-- filter destory() --");
	}
	
}
