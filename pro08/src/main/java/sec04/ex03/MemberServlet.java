package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	private MemberDAO memberDAO = MemberDAO.getInstance();
	
	private void runAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("runAdd...");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberVO memberVO = new MemberVO(id, pwd, name, email, null);
		memberDAO.addMember(memberVO);
		goMemberList(response);
	
		
	}
	
	private void goMemberList(HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		PrintWriter out = response.getWriter();
		String html = "<html>";
		html += "<script>";
		html += "	self.location = '/member?command=list';";
		html += "</script>";
		html += "</html>";
		out.print(html);
	}
	
	private void runDelete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		memberDAO.delete(id); 
		goMemberList(response);
	}
	
	private void runList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberVO> memberList = memberDAO.listMembers();
		
		//viewServlet으로 포워딩
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/viewMembers");
		// 회원목록을 request 바인딩
		request.setAttribute("memberList", memberList);
		dispatcher.forward(request, response);
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("중단점 전");
		response.setContentType("text/html;charset=utf-8");
		//System.out.println("중단점 후");
		String command = request.getParameter("command");
		if (command == null || command.equals("list")) {
			runList(request, response);
		} else if (command.equals("add")) {
			runAdd(request, response);
		} else if (command.equals("update")) {
			
		} else if (command.equals("delete")) {
			runDelete(request, response);
		}
		
		/*
		switch (command) {
		case "add":
			runAdd(request, response);
			break;
		case "list":
			runList(request, response);
			break;
		}
		*/
		
		
		
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
