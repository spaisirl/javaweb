package sec04.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login2")
public class LoginTest2 extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		LoginImpl loginImpl = new LoginImpl(id, pw);
		session.setAttribute("loginImpl", loginImpl);
		System.out.println("total:" + loginImpl.total);
		// session.removeAttribute("loginImpl");
		
	
	}

}
