package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/join")
public class JoinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String course = request.getParameter("course");
//		System.out.println("course:"+course);
		
		// 과목 두개 선택
		/*
		String[] courses = request.getParameterValues("course");
		for (String course : courses) {
			System.out.println(course);
		}
		*/
		
		Enumeration<String> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + " : ");
			if (names.equals("course")) {
				String[] courses = request.getParameterValues(name);
				for(String course : courses) {
					System.out.println(course + " ");
				}
			} else {
				String val = request.getParameter(name);
				System.out.println(val);
			}
			System.out.println("\n-----------------");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
