package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	private final float D_RATE = 0.01F;
	private final float Y_RATE = 0.1F;
	private final float W_RATE = 0.2F;
	private final float P_RATE = 1.5F;
	private final float E_RATE = 2.1F;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		

		System.out.println("command:" + command);
		System.out.println("won:" + won);
		System.out.println("operator:" + operator);
		
		//html
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("		<meta charset='utf-8'>");
		sb.append("		<title>환율 계산기</title>");
		sb.append("</head>");
		sb.append("<body>");
		
		if (command !=null && command.equals("calculate")) {
			//결과화면
			int iWon = Integer.parseInt(won);
			float result = 0f;
			switch (operator) {
				case "d":
					result = iWon * D_RATE;
					break;
				case "y":
					result = iWon * Y_RATE;
					break;
				case "w":
					result = iWon * W_RATE;
					break;
				case "p":
					result = iWon * P_RATE;
					break;
				case "e":
					result = iWon * E_RATE;
					break;
		
			}
			
			sb.append("<h1>변환결과</h1>");
			sb.append("<h2>" + result + "</h2>");
			sb.append("<a href='/calc'>환율 계산기</a>");
			
		} else {
			
			sb.append("<form>");
			sb.append("		<input type='hidden' name='command' value='calculate'>");
			sb.append("		<h1>환율 계산기</h1>");
			sb.append("		원화:");
			sb.append("		<input type='number' name='won'>");
			sb.append("		<select name='operator'>");
			sb.append("		<option value='d'>달러</option>");
			sb.append("		<option value='y'>엔화</option>");
			sb.append("		<option value='p'>파운드</option>");
			sb.append("		<option value='e'>유로</option>");
			sb.append("		<option value='w'>위안</option>");
			sb.append("		</select>");
			sb.append("		<button type='submit'>변환</button>");
			sb.append("</form>");
			
			
		}
		
		sb.append("</body>");
		sb.append("<html>");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
