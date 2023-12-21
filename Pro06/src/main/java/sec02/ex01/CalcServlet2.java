package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//직접해보기 계산기
@SuppressWarnings("serial")
@WebServlet("/calc2")
public class CalcServlet2 extends HttpServlet {
       
	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		int num1 = 0;
		int num2 = 0;
		if (request.getParameter("num1") != null &&
				request.getParameter("num2") != null) {
			num1 = Integer.parseInt(request.getParameter("num1"));
			num2 = Integer.parseInt(request.getParameter("num2"));
		}
		String oper = request.getParameter("oper");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("		<meta charset='utf-8'>");
		sb.append("		<title>간단 계산기</title>");
		sb.append("</head>");
		sb.append("<body>");
		
		if (oper != null && oper.length() > 0) {
			String symbol = null;
			int result = 0;
			switch (oper) {
			case "add":
				symbol = " + ";
				result = num1 + num2;
				break;
			case "sub":
				symbol = " - ";
				result = num1 - num2;
				break;
			case "mul":
				symbol = " * ";
				result = num1 * num2;
				break;
			case "div":
				symbol = " / ";
				result = num1 / num2;
				break;
			case "mod":
				symbol = " % ";
				result = num1 % num2;
				break;
			}
			sb.append(num1 + symbol  + num2 + " = " + result);
			sb.append("<br><a href='/calc2?num1=" + num1 + "&num2=" + num2 + "'>계산기로 돌아가기</a>");
		} else {
			sb.append("<form action='/calc2' method='get'>");
			sb.append("		<table>");
			sb.append("			<tr>");
			sb.append("				<td>");
			sb.append("					<input type='number' name='num1' value='" + num1 + "'>");
			sb.append("				</td>");
			sb.append("			</tr>");
			sb.append("			<tr>");
			sb.append("				<td>");
			sb.append("					<input type='radio' name='oper' value='add' checked>+");
			sb.append("					<input type='radio' name='oper' value='sub'>-");
			sb.append("					<input type='radio' name='oper' value='mul'>*");
			sb.append("					<input type='radio' name='oper' value='div'>/");
			sb.append("					<input type='radio' name='oper' value='mod'>%");
			sb.append("				</td>");
			sb.append("			</tr>");
			sb.append("			<tr>");
			sb.append("				<td>");
			sb.append("					<input type='number' name='num2' value='" + num2 + "'>");
			sb.append("				</td>");
			sb.append("			</tr>");
			sb.append("			<tr>");
			sb.append("				<td>");
			sb.append("					<button type='submit'>결과보기</button>");
			sb.append("				</td>");
			sb.append("			</tr>");
			sb.append("		</table>");
			sb.append("</form>");
		}
		
		
		
		sb.append("</body>");
		sb.append("</html>");
		writer.println(sb.toString());
	}

}