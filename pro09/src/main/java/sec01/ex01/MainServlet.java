package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html;charset=utf-8");
			String html = "<html>";
			HttpSession session = request.getSession();
//			String loginId = (String)session.getAttribute("loginId");
			LoginDTO dto =  (LoginDTO)session.getAttribute("loginDTO");
			
			if (dto == null) {
//				message = "로그인 하지 않았습니다.";
				html += "<scirpt>";
				html += "	alert('로그인 하지 않았습니다.');";
				html += "self.location = '/login.html';";
				html += "</scirpt>";
			} else {
				html += "<h1>" + dto.getId() + "("+ dto.getName() + ")님 반갑습니다.</h1>";
			}
			html += "</html>";
			response.getWriter().print(html);
		}
		
	
}
