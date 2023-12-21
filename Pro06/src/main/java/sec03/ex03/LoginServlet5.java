package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	//자바 스크립트를 이용한 폼 전송
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String addr = request.getParameter("addr");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String html = "<html>";
		html += "아이디:" + user_id + "<br>";
		html += "패스워드:" + user_pw + "<br>";
		html += "주소:" + addr + "<br>";
		html += "</html>";
		
		writer.println(html);
	}

}
