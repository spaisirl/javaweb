package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/member3")
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
		html += "	self.location = '/member3?command=list';";
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
		
		
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("		<meta charset='utf-8'>");
		sb.append("		<title></title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>회원 목록</h1>");
		sb.append("<div><a href='/memberForm.html'>회원 등록</div>");
		sb.append("<table border='1'>");
		sb.append("<tr>");
		sb.append("	<th>아이디</th>");
		sb.append("	<th>비밀번호</th>");
		sb.append("	<th>이름</th>");
		sb.append("	<th>이메일</th>");
		sb.append("	<th>가입일</th>");
		sb.append("	<th>삭제</th>");
		sb.append("<tr>");
		
		for(MemberVO vo : memberList) {
			sb.append("<tr>");
			sb.append("			<td>" + vo.getId() + "</td>");
			sb.append("			<td>" + vo.getPwd().substring(0,2) + "*****" +"</td>");
			sb.append("			<td>" + vo.getName().substring(0, 1) + "*" + vo.getName().substring(vo.getName().length()-1) + "</td>");
			sb.append("			<td>" + vo.getEmail() + "</td>");
			sb.append("			<td>" + vo.getJoindate() + "</td>");
			sb.append("			<td><a href='/member3?command=delete&id="+vo.getId()+"'>삭제</a></td>");
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		PrintWriter out = response.getWriter();
		out.print(sb.toString());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("중단점 전");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("중단점 후");
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
