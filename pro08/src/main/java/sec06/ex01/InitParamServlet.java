package sec06.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(
		urlPatterns = { 
				"/sInit", 
				"/sInit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@jweb.com", description = "관리자이메일"), 
				@WebInitParam(name = "tel", value = "010-1111-1111", description = "관리자연락처")
		},
		loadOnStartup = 2)


public class InitParamServlet extends HttpServlet {
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("InitParamServlet");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = 	this.getInitParameter("email");
		String tel = this.getInitParameter("tel");
		System.out.println("email:" + email);
		System.out.println("tel:" + tel);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
