package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/*")
public class EncoderFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("before doFilter");
		request.setCharacterEncoding("utf-8");
		
		long start = System.currentTimeMillis();
		chain.doFilter(request, response); // 요청처리
		long end = System.currentTimeMillis();
		System.out.println("걸린시간:" + (end - start));
		System.out.println("after doFilter");
		

	}



}
