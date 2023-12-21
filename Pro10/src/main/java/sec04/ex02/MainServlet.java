package sec04.ex02;

import java.io.IOException;
import java.util.List;

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
		HttpSession session = request.getSession();
		
		response.setContentType("text/html;charset=utf-8");
		String html = "<html>";
		html += "아이디:" + session.getAttribute("id") + "<br>";
		html += "비번:" + session.getAttribute("pw") + "<br>";
		html += "지역:" + session.getAttribute("addr") + "<br>";
		html += "<html>";
		
		// 현재 로그인한 사용자 아이디
		List<String> list = (List<String>) getServletContext().getAttribute("list");
		if (list != null && list.size() > 0) {
			html += "로그인 중인 아이디<br>";
			for (String id : list) {
				html += "<div>" + id + "</div>";
			}
		} else {
			html += "접속 중인 아이디가 없습니다.";
		}
		
		
		html += "<a href='/logout'>로그아웃</a>";
		html += "</html>";
		response.getWriter().print(html);
	
	}

}
