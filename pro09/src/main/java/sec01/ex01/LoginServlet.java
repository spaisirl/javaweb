package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private MemberDAO memberDAO = MemberDAO.getInstance();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		LoginDTO dto = memberDAO.loginInfo(id, pwd);
		
		if (id.equals(id) && pwd.equals(pwd)) {
			System.out.println("로그인 성공");
			HttpSession session =  request.getSession();
//			session.setAttribute("loginId", id);
			session.setAttribute("loginDTO", dto);
			response.sendRedirect("/main");
		} else {
			System.out.println("로그인 실패");
			response.sendRedirect("/login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
