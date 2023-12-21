package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("second");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("안녕하세요. second 입니다.");
		String id = request.getParameter("id");
		out.println("id:" + id);
		Integer age = (Integer)request.getAttribute("age");
		out.print("age:" + age);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
