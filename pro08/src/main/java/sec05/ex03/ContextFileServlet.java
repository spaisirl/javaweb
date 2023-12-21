package sec05.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String html = "<html>";
		html += "<h1>메뉴 이름</h1>";
		
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			html += "<div>" + line + "</div>";
		}
		html += "</html>";
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
