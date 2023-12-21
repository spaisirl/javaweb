package sec05.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/cset")
public class SetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// SetServlet에 데이터 바인딩
		// set -> get
		request.setAttribute("id", "hong");
		
		ServletContext servletContext = getServletContext();
		// servletContext.setAttribute("id", "hong");
		servletContext.setAttribute("pw", "1234");
		response.sendRedirect("/cget");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
