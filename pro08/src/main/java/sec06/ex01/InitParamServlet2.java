package sec06.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/InitParamServlet2")
public class InitParamServlet2 extends HttpServlet {
	

	
	@Override
	public void init() throws ServletException {
		System.out.println("InitParamServlet2");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = 	this.getInitParameter("email");
		String tel = this.getInitParameter("tel");
		System.out.println("email:" + email);
		System.out.println("tel:" + tel);
	}

}
