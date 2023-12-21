package sec04.ex02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutTest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// session.removeAttribute("id"); // 바인딩된 값 중에 하나를 제거
		// 현재 세션 무효화 -> 로그아웃
		session.removeAttribute("loginImpl");
		session.invalidate(); // 세션 전체를 날림 -> 모든 바인딩 된 값 제거
		response.sendRedirect("/main");
		
	}

}
