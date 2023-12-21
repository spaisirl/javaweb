package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("second doGet");
		 // type을 number로 해도 string으로 해야한다.
		printParameter(req);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("second doPost");
		req.setCharacterEncoding("utf-8");
		printParameter(req);
	}

	private void printParameter(HttpServletRequest req) {
		String second_uname = req.getParameter("second_uname");
		String second_uage = req.getParameter("second_uage");
		System.out.println("second uname:" + second_uname);
		System.out.println("second uage:" + second_uage);
	}

	@Override
	public void destroy() {
		
		System.out.println("second doPost");
	}

	@Override
	public void init() throws ServletException {
		
		System.out.println("second init");
	}
	
	
	
}
