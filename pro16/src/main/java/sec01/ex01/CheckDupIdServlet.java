package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/checkDupId")
public class CheckDupIdServlet extends HttpServlet {
	private MemberDAO dao = MemberDAO.getInstance();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet...");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		boolean result = dao.checkDupId(id);
		System.out.println("result:" + result);
		
		PrintWriter out = response.getWriter();
		out.print(result); // 중복 -> if문에서 중복 체크
	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
