package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/guguTest")
public class GuguTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dan = Integer.parseInt(request.getParameter("dan"));
		
		String html = "<html>";
		html += "<table border='1' style='width:500px;'>";
		html += "	<tr style=\"background-color:yellow;\"><td colspan='2'>" + dan + "단 출력</td></tr>";
		for (int i = 1 ; i <=9; i++) {
			html += "<tr>";
			html += "	<td style='width:250px;'>" + dan + " * " + i + "</td>";
			html += "<td>" + (dan * i) + "</td>";
			html += "</tr>";
		}
		html += "</table>";
		html += "</html>";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(html);
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
