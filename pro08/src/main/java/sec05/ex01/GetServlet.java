package sec05.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cget")
public class GetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 // SetServlet에 바인딩 된 데이터 가져오기
		String id = (String)request.getAttribute("id");
		System.out.println("id:" + id); // id : null
		
		ServletContext  servletContext = getServletContext();
	//	String id = (String)servletContext.getAttribute("id");
	//	System.out.println("id:" + id);
		String pw = (String)servletContext.getAttribute("pw");
		System.out.println("pw:" + pw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
