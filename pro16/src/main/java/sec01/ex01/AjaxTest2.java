package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=utf-8");
		String result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		result += "<main>";
		result += "		<book>";
		result += "			<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>";
		result += "			<writer><![CDATA[인포북스 저 | 이병승]]></writer>";
		result += "			<image><![CDATA[/images/cat.png]]></image>";
		result += "		</book>";
		result += "		<book>";
		result += "			<title><![CDATA[모두의 파이썬]]></title>";
		result += "			<writer><![CDATA[길벗 저 | 이승찬]]></writer>";
		result += "			<image><![CDATA[/images/rabbit.png]]></image>";
		result += "		</book>";
		result += "</main>";
		
		response.getWriter().write(result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
