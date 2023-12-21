package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String user_id = request.getParameter("user_id");
			String user_pw = request.getParameter("user_pw");
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter writer = response.getWriter();
			
			String html = "<html>";
			html += "아이디:" + user_id + "<br>";
			html += "비밀번호:" + user_pw + "<br>";
			html += "</html>";
			
			writer.println(html);
			
			
	}

}
