package sec01.ex01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/first")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("first");
		//리다이렉트 방식
		// 주소창 first - > second
		//response.sendRedirect("/second");
		
		// 데이터 바인딩
		request.setAttribute("age", 30); // (String, object)
		
		//포워드 방식
		//주소창이 바뀌지 않는다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("/second");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
