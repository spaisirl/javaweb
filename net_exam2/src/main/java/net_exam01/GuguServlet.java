package net_exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
//@WebServlet("/gugu")
public class GuguServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
				
		String html = "<html>";
		
		if(num1 < 1 || num1 >= 10) {
			html += "<h1>입력값이 범위에서 벗어났습니다.</h1>";
			html += "<a href='/net_exam/main.html'>메인</a>";
		} else if (num2 < 1 || num2 >= 10) {
			html += "<h1>입력값이 범위에서 벗어났습니다.</h1>";
			html += "<a href='/net_exam/main.html'>메인</a>";		
		} else {
		
		html += "<table border='1' style='width:500px;'>";
		html += "<style>#result {background-color: red; color: white;}</style>";
		html += "	<tr><td colspan='2'>" + num1 + "단 출력</td></tr>";
		
		
		for (int i = 1 ; i <=9; i++) {
		
		
			if (num2 == i ) {
				html += "	<tr style=\"width:250px; background-color:red; color:white;\">";
				html += " <td>" + num1 + " * " + i + "</td>";
				html += "<td>" + (num1 * i) + "</td>";
				html += "	</tr>";
			} else {
				
				html += "<tr>";
				html += "	<td>" + num1 + "*" + i + "</td>";
				html += " 	<td>" + (num1 * i) + "</td>";
				html += "</tr>";
			
				}
			}
			html += "</table>";
		}
		html += "</html>";
	
		
		PrintWriter out = response.getWriter();
		
		out.println(html);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
