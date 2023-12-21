package sec02.ex01;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/get")
public class GetCookieValue extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		
		if (cookies == null || cookies.length == 0) {
			return;
		}
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			String uValue = URLDecoder.decode(value, "utf-8");
			
			System.out.println(name + "=" + uValue);
		}
		
	}

}
