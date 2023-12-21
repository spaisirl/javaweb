package sec02.ex01;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = URLEncoder.encode("헬로우 쿠키", "utf-8");
		Cookie cookie = new Cookie("CookieTest", value);
		cookie.setMaxAge(60 * 60 * 24); // 하루		
//		cookie.setMaxAge(-1); // 브라우저 끄면 쿠키 사라짐	
		response.setContentType("text/html;charset=utf-8");
		response.addCookie(cookie);
		response.getWriter().print("<html><h1>쿠키전송완료</h1></html>");
		// 결과 get -> set n초 후 쿠키 사라짐
	}

}
