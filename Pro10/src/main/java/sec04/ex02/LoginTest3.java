package sec04.ex02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login3")
public class LoginTest3 extends HttpServlet {
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("id", request.getParameter("id"));
		session.setAttribute("pw", request.getParameter("pw"));
		session.setAttribute("addr", "ulsan");
		Loginimpl3 loginImpl = new Loginimpl3();
		loginImpl.id = request.getParameter("id");
		loginImpl.pw = request.getParameter("pw");
		
		String sessionId = session.getId();
		
		
		
		System.out.println("sessionId:" + sessionId);
		
		List<String> list = (List<String>) getServletContext().getAttribute("list"); //
		if (list == null) {
			list = new ArrayList<>();
		}
		list.add(loginImpl.id);
		getServletContext().setAttribute("list", list);
		
		/*
		if (session.isNew()) {
			System.out.println("isNew");
			session.setAttribute("loginImpl", loginImpl);
		} else {
			System.out.println("isOld");
		}
		*/
		response.sendRedirect("/main");
	
	}

}
