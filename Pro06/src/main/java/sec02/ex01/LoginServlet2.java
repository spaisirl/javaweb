package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		String result = null;
		
		if (id.equals("java") && pw.equals("1234")) {
			result = "로그인 성공";
		} else {
			result = "로그인 실패";
		}
		
		//응답 객체
		response.setContentType("text/html;charset=utf-8");
		String html = "<html>\n";
		html += "<head>\n";
		html += "<meta charset='utf-8'>\n";
		html += "<title>로그인 결과</title>\n";
		html += "</head>\n";
		html += "<body>\n";
		html += "<h1>" + result + "</h1>\n";
		html += "</body>\n";
		html += "</html>\n";
		
		PrintWriter out = response.getWriter();
		out.println(html);
		
	
		
	}

}
